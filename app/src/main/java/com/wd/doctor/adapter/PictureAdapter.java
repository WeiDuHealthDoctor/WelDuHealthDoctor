package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.view.PictureActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.adapter
 * @ClassName: PictureAdapter
 * @Author: YuYanHe
 * @CreateDate: 2020/3/9 16:57
 */
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.Holder> {
    List<AvatarBean.ResultBean> list = new ArrayList<>();
    Context context;

    public PictureAdapter(List<AvatarBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.picture_adapter, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.picture_image.setImageURI(list.get(position).getImagePic());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picturessAdapter.picture(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    PicturessAdapter picturessAdapter;

    public interface PicturessAdapter {
        void picture(int position);
    }


    public void setPicture(PicturessAdapter picture) {
        this.picturessAdapter = picture;
    }

    public class Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView picture_image;

        public Holder(@NonNull View itemView) {
            super(itemView);
            picture_image = itemView.findViewById(R.id.picture_image);
        }
    }
}
