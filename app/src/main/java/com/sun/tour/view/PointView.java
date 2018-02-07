package com.sun.tour.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanyg on 2018/2/7.
 */

public class PointView extends View {

    private Paint paint;
    private int totalCount;
    private int position;
    private int magin;

    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {

        magin = DensityUtil.dp2px(20);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);

        int heightDefaultSize = DensityUtil.dp2px(30);
        int widthDefaultSize = DensityUtil.dp2px(100);

        if (widthMeasureMode == MeasureSpec.AT_MOST && heightMeasureMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(widthDefaultSize,heightDefaultSize);
        }else if (widthMeasureMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthDefaultSize,heightMeasureSpec);
        }else if (heightMeasureMode == MeasureSpec.AT_MOST){
            super.onMeasure(widthMeasureSpec,heightDefaultSize);
            setMeasuredDimension(widthMeasureSpec,heightDefaultSize);
        }
    }

    public void setTotalCount(int totalCount){

        this.totalCount = totalCount;
        invalidate();
    }

    public void setColor(int color){

        paint.setColor(color);
        invalidate();
    }

    public void setSelectItem(int position){

        this.position = position;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (totalCount <= 1){
            return;
        }
        int width = getWidth();
        int height = getHeight();
        List<Float> floats = initPoint(width);
        for (int i = 0; i < floats.size(); i++) {

            if (position == i){
                paint.setStrokeWidth(30);
            }else{
                paint.setStrokeWidth(20);
            }
            canvas.drawPoint(floats.get(i),height/2,paint);
        }
    }

    private List<Float> initPoint(int width) {

        int v = totalCount / 2;
        float startX = 0f;
        if (totalCount%2 == 0){
            startX = width/2 - (v-1)*magin - magin/2;
        }else{
            startX = width/2 - v*magin;
        }

        List<Float> data = new ArrayList<>();
        for (int i = 0; i < totalCount; i++) {
            data.add(startX+magin*i);
        }

        return data;
    }
}
