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
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        sizeScreenWidth = MeasureSpec.getSize(widthMeasureSpec);
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
            left += measuredWidth + marginHorizontal;
            if(i== getChildCount() -1){
                top += measuredHeight;
            }
        }
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
