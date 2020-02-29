package com.wd.doctor.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.presenter.IPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataActivity extends BaseActivity {


    @BindView(R.id.img_backmyy)
    ImageView imgBackmyy;
    @BindView(R.id.text_zl_name)
    TextView textZlName;
    @BindView(R.id.text_zl_Hospital)
    TextView textZlHospital;
    @BindView(R.id.text_zl_Departments)
    TextView textZlDepartments;
    @BindView(R.id.text_zl_Title)
    TextView textZlTitle;
    @BindView(R.id.text_zl_Introduction)
    TextView textZlIntroduction;
    @BindView(R.id.text_zl_Goodat)
    TextView textZlGoodat;

    @Override
    protected void initData() {
         imgBackmyy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
