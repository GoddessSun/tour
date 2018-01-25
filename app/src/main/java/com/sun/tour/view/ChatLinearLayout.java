package com.sun.tour.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.util.DensityUtil;

/**
 * Created by hanyg on 2018/1/25.
 */

public class ChatLinearLayout extends LinearLayout {
    private Context context;
    private Paint paint;
    private int magin;
    private int wM;
    public ChatLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public ChatLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ChatLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        this.context = context;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.ROUND);
        magin = DensityUtil.dp2px(10);
        wM = DensityUtil.dp2px(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth() - wM;
        int height = getHeight() - wM;
        RectF left_topRectF = new RectF(magin,magin,magin+magin,magin+magin);
        canvas.drawArc(left_topRectF,180,90,true,paint);
        RectF right_topRectF = new RectF(width - magin,magin,width,magin+magin);
        canvas.drawArc(right_topRectF,-90,90,true,paint);
        RectF left_bottomRectF = new RectF(magin,height - magin,magin+magin,height);
        canvas.drawArc(left_bottomRectF,90,90,true,paint);
        RectF right_bottomRectF = new RectF(width - magin,height - magin,width,height);
        canvas.drawArc(right_bottomRectF,0,90,true,paint);

        RectF rectF1 = new RectF(magin+magin/2,magin,width - magin/2,height);
        canvas.drawRect(rectF1,paint);
        RectF rectF2 = new RectF(magin,magin+magin/2,width,height - magin/2);
        canvas.drawRect(rectF2,paint);

        Path path = new Path();
        path.moveTo(magin,magin*2);
        path.lineTo(0,magin*2+magin);
        path.lineTo(magin,magin*2+magin*2);
        path.close();
        canvas.drawPath(path,paint);
    }
}
