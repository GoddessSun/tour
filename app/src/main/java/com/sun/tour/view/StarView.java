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
 * Created by hanyg on 2018/1/26.
 */

public class StarView extends View {

    private int startNum = 5;
    private float radius;
    private int magin;
    private Paint paint;

    public StarView(Context context) {
        super(context);
    }

    public StarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    public StarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {

        radius = DensityUtil.dp2px(20);
        magin = DensityUtil.dp2px(10);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3f);
        paint.setColor(Color.RED);
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
        float width = getWidth();
        float height = getHeight();
        List<Position> position = position(width, height);
        if (position != null){

            for (Position p : position) {


                Position a = new Position(p.getX(),p.getY() - radius);
                Position b = new Position(p.getX()+cos(270-72),p.getY()+sin(180+18));
                Position c = new Position(p.getX()+cos(270-72*2),p.getY()+sin(90+18));
                Position d = new Position(p.getX()+cos(270-72*3),p.getY()+sin(72));
                Position e = new Position(p.getX()+cos(270-72*4),p.getY()+sin(-18));
                Position f = positionXY(b,c,d,e);

                canvas.drawPoints(new float[]{

                        a.getX(),a.getY(),
                        b.getX(),b.getY(),
                        c.getX(),c.getY(),
                        d.getX(),d.getY(),
                        e.getX(),e.getY(),
                        f.getX(),f.getY()
                },paint);
//                Path path = new Path();
//                path.moveTo(a.getX(),a.getY());
//                path.lineTo(c.getX(),c.getY());
//                path.lineTo(f.getX(),f.getY());
//                path.lineTo(d.getX(),d.getY());
//                path.lineTo(a.getX(),a.getY());
//                canvas.drawPath(path,paint);
//                path.reset();
//                path.moveTo(b.getX(),b.getY());
//                path.lineTo(f.getX(),f.getY());
//                path.lineTo(e.getX(),e.getY());
//                path.lineTo(b.getX(),b.getY());
//                canvas.drawPath(path,paint);
//                path.reset();
            }
        }
    }

    private Position positionXY(Position b,Position c,Position d,Position e){

        float A = (b.getY() - d.getY())/(b.getX() - d.getY());
        float B = b.getY() - b.getX()*A;

        float C = (c.getY() - e.getY())/(c.getX() - e.getY());
        float D = c.getY() - e.getX()*C;


        return new Position((D - B)/(A - C),C*(D - B)/(A - C)+D);
    }
    private float sin(float angle){

       return (float) (Math.sin(Math.PI*2/360*angle)*radius);
    }

    private float cos(float angle){
        return (float) (Math.cos(Math.PI*2/360*angle)*radius);
    }
    private List<Position> position(float width, float height){

        float v = width / startNum;
        float startX;
        float startY = height/2;
        int c = startNum/2;
        if (startNum%2 == 0){
            startX = width/2 - v/2 - (c - 1)*v;
        }else{
            startX = width/2 - v*c;
        }
        List<Position> data = new ArrayList<>();
        for (int i = 0; i < startNum; i++) {

            Position p = new Position();
            p.setX(startX+v*i);
            p.setY(startY);
            data.add(p);
        }
        return data;
    }
    class Position{

        private float x;
        private float y;

        public Position(){

        }
        public Position(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
    }
}
