package com.sun.tour.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by hanyg on 2018/1/30.
 */

public class FullRecyclerView extends RecyclerView {
    public FullRecyclerView(Context context) {
        super(context);
    }

    public FullRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FullRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,  MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
