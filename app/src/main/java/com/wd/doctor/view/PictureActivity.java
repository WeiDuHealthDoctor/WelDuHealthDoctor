package com.wd.doctor.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.PictureAdapter;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.presenter.IPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureActivity extends BaseActivity implements IContract.IViewAvatar {


    @BindView(R.id.picture_recy)
    RecyclerView pictureRecy;
    @BindView(R.id.btn_picture)
    Button btnPicture;
    private PictureAdapter pictureAdapter;

    @Override
    protected void initData() {
        IPresenter presenter = (IPresenter) p;
        presenter.getpictureAvatars();
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        pictureRecy.setLayoutManager(linearLayoutManager);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(pictureRecy);
    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_picture;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void avatarSuccess(AvatarBean avatarBean) {
        pictureAdapter = new PictureAdapter(avatarBean.getResult(), this);
        pictureRecy.setAdapter(pictureAdapter);
        pictureAdapter.setPicture(new PictureAdapter.PicturessAdapter() {
            @Override
            public void picture(int position) {

            }
        });
    }
}
