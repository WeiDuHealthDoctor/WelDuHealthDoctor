package com.wd.doctor.customize;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.customize
 * @ClassName: SeachView
 * @Author: YuYanHe
 * @CreateDate: 2020/3/2 17:32
 */
public class SeachView extends ViewGroup {
    private int sizeScreenWidth;

    public SeachView(Context context) {
        super(context);
    }

    public SeachView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //先调用这个方法 测量孩子的宽高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //获取到绿View的宽
        sizeScreenWidth = MeasureSpec.getSize(widthMeasureSpec);
        //每一行第一个孩子据左边的间距
        int left = 20;
        //第一行据上边的间距
        int top = 0;
        //定义一个孩子yu孩子之间的间距
        int marginHorizontal = 20;

        //开始循环遍历孩子计算每行的宽度，和累加的高度
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            //拿到每一个孩子的宽高
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();

            //如果大于绿View的宽 就换行
            if (left + measuredWidth >= sizeScreenWidth) {
                //行高累加
                top += measuredHeight;
                left = 20;
            }
            //如果说不换行 ，行宽累加
            left += measuredWidth + marginHorizontal;
            //如果是最后一个view的情况下
            if(i== getChildCount() -1){
                top += measuredHeight;
            }
        }
        //设置滤View的高度可宽度
        setMeasuredDimension(sizeScreenWidth , top);
    }

    //开始布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 20;
        int top = 0;
        int marginHorizontal = 20;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (left + measuredWidth >= sizeScreenWidth) {
                top += measuredHeight;
                left = 20;
            }
            childAt.layout(left,top,left + measuredWidth, top + measuredHeight);
            left += measuredWidth + marginHorizontal;
        }
    }
}
