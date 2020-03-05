package com.wd.doctor.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.presenter.IPresenter;

import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

public class ShowActivity extends BaseActivity implements IContract.IViewAvatar {
    SimpleDraweeView show_doctorimage;
    private String imagePic;
    Button bt_answer, bt_inquiry, bt_manager;
    TextView zeng, doctoraddress, doctorzhi;

    @Override
    protected void initData() {
        IPresenter presenter = (IPresenter) p;
        presenter.getAvatars();

        bt_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowActivity.this, AnswerActivity.class));
            }
        });
        bt_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this, MangerActivity.class);
                intent.putExtra("imagePic", imagePic);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        show_doctorimage = findViewById(R.id.doctorimage);
        bt_answer = findViewById(R.id.bt_answer);
        bt_inquiry = findViewById(R.id.bt_inquiry);
        bt_manager = findViewById(R.id.bt_manager);
        doctorzhi = findViewById(R.id.doctorzhi);
        zeng = findViewById(R.id.zeng);
        doctoraddress = findViewById(R.id.doctoraddress);
    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_show;
    }


    boolean isState = true;

    public void onBackPressed() {
        if (isState) {
            isState = false;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isState = true;
                }
            }, 2000);
        } else {
            finish();
        }
    }

    @Override
    public void avatarSuccess(AvatarBean avatarBean) {
        Log.i("aaa", "avatarSuccess: " + avatarBean);

        for (int i = 0; i < 2; i++) {
            imagePic = avatarBean.getResult().get(i).getImagePic();

        }
        SharedPreferences xx = getSharedPreferences("xx", MODE_PRIVATE);
        imagePic = xx.getString("imagePic", "");
        show_doctorimage.setImageURI(imagePic);
    }
}
