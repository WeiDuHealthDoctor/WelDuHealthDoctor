package com.wd.doctor.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.presenter.IPresenter;

public class PictureActivity extends BaseActivity {


    @Override
    protected void initData() {

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
        return R.layout.activity_picture;
    }
}
