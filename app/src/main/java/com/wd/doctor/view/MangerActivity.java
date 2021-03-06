package com.wd.doctor.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
    private PopupWindow popupWindow;
    private SharedPreferences xx;

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
        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow();
            }
        });
    }

    private void showPopWindow() {
        //找到pop弹窗布局
        final View view = LayoutInflater.from(MangerActivity.this).inflate(R.layout.my_pop, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);
        //设置高度
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //点击以外的地方关闭
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        //activity的布局
         View rootView = LayoutInflater.from(MangerActivity.this).inflate(R.layout.activity_show, null);
        view.findViewById(R.id.bt_change).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MangerActivity.this, ChangeActivity.class);
//                        SharedPreferences.Editor edit = xx.edit();
//                        edit.remove("imagePic");
//                        edit.commit();
                      popupWindow.dismiss();
                        startActivity(intent);
                    }
                });

        view.findViewById(R.id.bt_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //popupWindow消失屏幕变为不透明
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });
        //popupWindow出现屏幕变为半透明
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        popupWindow.update();
        //位置
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);

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
