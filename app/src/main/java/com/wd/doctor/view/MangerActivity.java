package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.presenter.IPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MangerActivity extends BaseActivity {


    @BindView(R.id.my_image)
    SimpleDraweeView myImage;
    @BindView(R.id.my_back)
    ImageView myBack;
    @BindView(R.id.my_message)
    ImageView myMessage;
    @BindView(R.id.my_query)
    TextView myQuery;
    @BindView(R.id.fang)
    ImageView fang;
    @BindView(R.id.my_history)
    ImageView myHistory;
    @BindView(R.id.text_history)
    TextView textHistory;
    @BindView(R.id.my_wallet)
    ImageView myWallet;
    @BindView(R.id.text_wallet)
    TextView textWallet;
    @BindView(R.id.my_suggest)
    ImageView mySuggest;
    @BindView(R.id.text_suggest)
    TextView textSuggest;
    @BindView(R.id.my_reply)
    ImageView myReply;
    @BindView(R.id.text_reply)
    TextView textReply;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String imagePic = extras.getString("imagePic");
        myImage.setImageURI(imagePic);
    }

    @Override
    protected void initView() {
        myBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        fang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MangerActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_manger;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
