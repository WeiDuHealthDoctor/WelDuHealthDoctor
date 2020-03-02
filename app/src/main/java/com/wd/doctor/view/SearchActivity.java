package com.wd.doctor.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.SearchAdpter;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.InquireSickBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.presenter.IPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity implements IContract.IViewInquire {


    @BindView(R.id.search_back)
    ImageView searchBack;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.text_search)
    TextView textSearch;
    @BindView(R.id.searchrec)
    RecyclerView searchrec;
    private IPresenter iPresenter;
    private String search;

    @Override
    protected void initData() {
        iPresenter = (IPresenter) p;
    }

    @Override
    protected void initView() {
        search = editSearch.getText().toString();

        searchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        searchrec.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_search;
    }

    @Override
    public void InquireSuccess(InquireSickBean inquireSickBean) {
        Log.i("TAG", "InquireSuccess: " + inquireSickBean);
        textSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iPresenter.getSearchSickCircle("头");
                List<InquireSickBean.ResultBean> result = inquireSickBean.getResult();
                SearchAdpter searchAdpter = new SearchAdpter(result, SearchActivity.this);
                searchrec.setAdapter(searchAdpter);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
