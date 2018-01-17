package com.sun.tour.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by hanyg on 2018/1/16.
 */

public class FullGridView extends GridView {
    public FullGridView(Context context) {
        super(context);
    }

    public FullGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,  MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
