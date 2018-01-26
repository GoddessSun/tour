package com.sun.tour.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.sun.tour.R;

/**
 * Created by hanyg on 2018/1/25.
 */

public class ChatLinearLayout extends LinearLayout {
    private Context context;
    private Paint paint;
    private int magin;
    private int wM;
    private int backgroundColor;
    private int lineColor;
    private int position;
    private int maginHeight;
    private float mHeight;

    public ChatLinearLayout(Context context) {
        super(context);
    }

    public ChatLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ChatLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context,AttributeSet attrs) {

        this.context = context;
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ChatLinearLayout);
        backgroundColor = arr.getColor(R.styleable.ChatLinearLayout_bg, getResources().getColor(R.color.white));
        position = arr.getInt(R.styleable.ChatLinearLayout_position, 1);
        mHeight = arr.getDimension(R.styleable.ChatLinearLayout_mHeight, DensityUtil.dp2px(50));
        lineColor = getResources().getColor(R.color.graycc);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.ROUND);
        magin = DensityUtil.dp2px(10);
        wM = DensityUtil.dp2px(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth() - magin;
        int height = getHeight() - wM;
        paint.setColor(backgroundColor);
        paint.setStyle(Paint.Style.FILL);
        RectF left_topRectF = new RectF(magin,wM,magin+magin,wM+magin);
        canvas.drawArc(left_topRectF,180,90,true,paint);
        RectF right_topRectF = new RectF(width - magin,wM,width,wM+magin);
        canvas.drawArc(right_topRectF,-90,90,true,paint);
        RectF left_bottomRectF = new RectF(magin,height - magin,magin+magin,height);
        canvas.drawArc(left_bottomRectF,90,90,true,paint);
        RectF right_bottomRectF = new RectF(width - magin,height - magin,width,height);
        canvas.drawArc(right_bottomRectF,0,90,true,paint);

        RectF rectF1 = new RectF(magin+magin/2,wM,width - magin/2,height);
        canvas.drawRect(rectF1,paint);
        RectF rectF2 = new RectF(magin,wM+magin/2,width,height - magin/2);
        canvas.drawRect(rectF2,paint);

        if (position == 1){
            Path path = new Path();
            path.moveTo(magin,mHeight/2 - magin);
            path.lineTo(0,mHeight/2);
            path.lineTo(magin,mHeight/2+magin);
            path.close();
            canvas.drawPath(path,paint);
        }else{
            Path path = new Path();
            path.moveTo(width,mHeight/2 - magin);
            path.lineTo(width+magin,mHeight/2);
            path.lineTo(width,mHeight/2+magin);
            path.close();
            canvas.drawPath(path,paint);
        }

        paint.setColor(lineColor);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(left_topRectF,180,90,false,paint);
        canvas.drawArc(right_topRectF,-90,90,false,paint);
        canvas.drawArc(left_bottomRectF,90,90,false,paint);
        canvas.drawArc(right_bottomRectF,0,90,false,paint);

        if (position == 1){
            canvas.drawLines(new float[]{
                    magin+magin/2,wM,width - magin/2,wM,
                    width,wM+magin/2,width,height - magin/2,
                    width - magin/2,height,magin+magin/2,height
            },paint);

            Path pathline = new Path();
            pathline.moveTo(magin,wM+magin/2);
            pathline.lineTo(magin,mHeight/2-magin);
            pathline.lineTo(0,mHeight/2);
            pathline.lineTo(magin,mHeight/2+magin);
            pathline.lineTo(magin,height-magin/2);
            canvas.drawPath(pathline,paint);
        }else{

            canvas.drawLines(new float[]{
                    magin+magin/2,wM,width - magin/2,wM,
                    magin,wM+magin/2,magin,height - magin/2,
                    width - magin/2,height,magin+magin/2,height
            },paint);

            Path pathline = new Path();
            pathline.moveTo(width,wM+magin/2);
            pathline.lineTo(width,mHeight/2-magin);
            pathline.lineTo(width+magin,mHeight/2);
            pathline.lineTo(width,mHeight/2+magin);
            pathline.lineTo(width,height-magin/2);
            canvas.drawPath(pathline,paint);
        }

    }
}
