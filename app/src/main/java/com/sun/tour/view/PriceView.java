package com.sun.tour.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.sun.tour.R;

/**
 *
 * 价格拖动View
 *
 * Created by hanyg on 2018/1/17.
 */

public class PriceView extends View {

    private Paint paint;
    private Context context;

    private int Radius;
    private int Magin;

    private int circleX1 = -1;
    private int circleY1 = -1;

    private int circleX2 = -1;
    private int circleY2 = -1;

    private boolean ismove1 = false;
    private boolean ismove2 = false;

    private int numCount = 6;
    private String[] price;
    private float textSize;
    private int textColor;
    private float textMagin;

    public PriceView(Context context) {
        super(context);
    }

    public PriceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public PriceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context,AttributeSet attrs) {
        this.context = context;
        Radius = DensityUtil.dp2px(15);
        Magin = DensityUtil.dp2px(10);
        TypedArray arr = context.obtainStyledAttributes(attrs,R.styleable.PriceView);
        textSize = arr.getDimension(R.styleable.PriceView_textSize, 17);
        textColor = arr.getColor(R.styleable.PriceView_textColor, Color.parseColor("#666666"));
        textMagin = arr.getDimension(R.styleable.PriceView_textmagin, Magin * 3 / 2);
        price = context.getResources().getStringArray(R.array.Price);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                down(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                move(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:
                up(event.getX(),event.getY());
                break;
        }
        return true;
    }

    private void move(float x, float y) {

        if (ismove1){
            if (x < getPaddingLeft() + Radius+Magin){
                circleX1 = getPaddingLeft() + Radius+Magin;
            }else if (x > getWidth() - getPaddingRight() - Magin - Radius){
                circleX1 = getWidth() - getPaddingRight() - Magin - Radius;
            }else{
                circleX1 = (int) x;
            }
            invalidate();
        }

        if (ismove2){
            if (x < getPaddingLeft() + Radius+Magin){
                circleX2 = getPaddingLeft() + Radius+Magin;
            }else if (x > getWidth() - getPaddingRight() - Magin - Radius){
                circleX2 = getWidth() - getPaddingRight() - Magin - Radius;
            }else{
                circleX2 = (int) x;
            }
            invalidate();
        }
    }

    private void up(float x, float y) {

        ismove1 = false;
        ismove2 = false;
    }

    private void down(float x, float y) {

        if ((x >= circleX1 - Radius && x <= circleX1 +Radius) && ( y >= circleY1 - Radius && y <= circleY1 +Radius)) {

            if ((x >= circleX2 - Radius && x <= circleX2 +Radius) && ( y >= circleY2 - Radius && y <= circleY2 +Radius)){
                ismove2 = true;
                ismove1 = false;
            }else{
                ismove1 = true;
                ismove2 = false;
            }

        }else{
            if ((x >= circleX2 - Radius && x <= circleX2 +Radius) && ( y >= circleY2 - Radius && y <= circleY2 +Radius)){
                ismove2 = true;
                ismove1 = false;
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);

        int defaultSize = DensityUtil.dp2px(80);
        if (widthMeasureMode == MeasureSpec.AT_MOST && heightMeasureMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(defaultSize,defaultSize);
        }else if (widthMeasureMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultSize,heightMeasureSpec);
        }else if (heightMeasureMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthMeasureSpec,defaultSize);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int startWidth = getPaddingLeft();
        int endWidth = getWidth() - getPaddingRight();

        int startHeight = getPaddingTop();
        int endHeight = getHeight() - getPaddingRight();

        if (circleX1 == -1 && circleY1 == -1){

            circleX1 = startWidth + Radius+Magin;
            circleY1 = startHeight + Radius + Magin+Magin/2;
        }

        if (circleX2 == -1 && circleY2 == -1){
            circleX2 = startWidth + Radius+Magin;
            circleY2 = startHeight + Radius + Magin+Magin/2;
        }

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#f5f5f5"));
        //开始半圆
        RectF leftRectF = new RectF(startWidth + Radius+Magin,startHeight + Radius + Magin,
                startWidth + Radius + Magin*2,startHeight + Radius+Magin*2);
        canvas.drawArc(leftRectF,90,180,true,paint);

        //中间矩形
        RectF centerRectF = new RectF(startWidth + Radius+Magin+Magin/2,startHeight + Radius + Magin,
                endWidth - Radius - Magin - Magin/2,startHeight +Radius+Magin*2);
        canvas.drawRect(centerRectF,paint);

        //结束半圆
        RectF rightRectF = new RectF(endWidth - Radius - Magin - Magin,startHeight + Radius + Magin,
                endWidth - Radius - Magin,startHeight + Radius+Magin*2);
        canvas.drawArc(rightRectF,-90,180,true,paint);


        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#fe6500"));
        RectF rectF;
        if (circleX1 < circleX2){
            rectF = new RectF(circleX1,circleY1 - Magin/2,circleX2,circleY1+Magin/2);
        }else{
            rectF = new RectF(circleX2,circleY1 - Magin/2,circleX1,circleY1+Magin/2);
        }
        canvas.drawRect(rectF,paint);

        //处理底部文字和标点
        int start = startWidth + Magin + Radius;
        int height = startHeight + Radius*3 + Magin;
        int l = (endWidth - startWidth - Magin*2 - Radius*2)/(price.length - 1);
        paint.setColor(textColor);
        for (int i = 0; i < price.length; i++) {
            paint.setStrokeWidth(7);
            canvas.drawPoint(start,height,paint);
            paint.setStrokeWidth(2);
            paint.setTextSize(textSize);
            String s = price[i];
            Rect rect = new Rect();
            paint.getTextBounds(s,0,s.length(),rect);
            canvas.drawText(s,start - rect.width()/2,height+textMagin,paint);
            start += l;
        }

        //画第一个圆
        paint.setStrokeWidth(2);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawCircle(circleX1,circleY1,Radius,paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#999999"));
        canvas.drawCircle(circleX1,circleY1,Radius,paint);

        //画第二个圆
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawCircle(circleX2,circleY2,Radius,paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#999999"));
        canvas.drawCircle(circleX2,circleY2,Radius,paint);

    }

}
