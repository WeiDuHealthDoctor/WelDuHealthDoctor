package com.wd.doctor.view;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.presenter.IPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeActivity extends BaseActivity {


    @BindView(R.id.image_cmera)
    ImageView imageCmera;
    @BindView(R.id.text_cmera)
    TextView textCmera;
    @BindView(R.id.xxz_image)
    SimpleDraweeView xxzImage;
    @BindView(R.id.according_image)
    ImageView accordingImage;
    @BindView(R.id.finishset)
    Button finishset;
    private PopupWindow popupWindow;
    private List<LocalMedia> images;

    @Override
    protected void initData() {
        imageCmera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow();
            }
        });
    }

    //popuwindow
    private void showPopWindow() {
        //找到pop弹窗布局
        final View view = LayoutInflater.from(ChangeActivity.this).inflate(R.layout.comera_photo, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);
        //设置高度
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //点击以外的地方关闭
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        //activity的布局
        View rootView = LayoutInflater.from(ChangeActivity.this).inflate(R.layout.activity_change, null);
        view.findViewById(R.id.bt_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //拍照
                PictureSelector.create(ChangeActivity.this)
                        .openCamera(PictureMimeType.ofImage())
                        .forResult(PictureConfig.CHOOSE_REQUEST);
                popupWindow.dismiss();
            }
        });

        view.findViewById(R.id.bt_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(ChangeActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(6)
                        .minSelectNum(1)
                        .imageSpanCount(4)
                        .selectionMedia(images)// 是否传入已选图片 List<LocalMedia> list
                        .selectionMode(PictureConfig.MULTIPLE)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
                popupWindow.dismiss();
            }
        });

        view.findViewById(R.id.bt_changeimage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeActivity.this, PictureActivity.class);
                startActivity(intent);
                popupWindow.dismiss();
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
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_change;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
