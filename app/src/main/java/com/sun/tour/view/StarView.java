package com.sun.tour.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.sun.tour.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanyg on 2018/1/26.
 */

public class StarView extends View {

    private static final int ALL = 0X0001;
    private static final int OTHER = 0X0002;

    private int startNum = 5;
    private float radius;
    private int magin;
    private Paint paint;
    private List<Position> position;
    private List<Float> evaluates;
    private Context context;
    private boolean touch;
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
        this.context = context;
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.StarView);
        startNum = arr.getInteger(R.styleable.StarView_count,5);
        radius = DensityUtil.dp2px(12);
        magin = DensityUtil.dp2px(10);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.RED);
    }

    public boolean isTouch() {
        return touch;
    }

    /**
     *
     * 设置是否可触摸
     *
     * @param touch
     */
    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    /**
     *
     *
     * 选中的个数
     *
     * @param max  最大评分
     * @param e   评分
     */
    public void setEvaluate(float max, float e){

        float base = max / startNum;
        if (e > max){
            e = max;
        }
        double v = e / base;
        float p1 = (int) v;
        float p2 = (float) (v - p1);
        evaluates = new ArrayList<>();
        for (int i = 0; i < p1; i++) {
            evaluates.add(1f);
        }
        if (p2 >0.5){
            evaluates.add(1f);
        }else{
            evaluates.add(0.5f);
        }
        int evSize = evaluates.size();
        for (int i = 0; i < startNum - evSize; i++) {

            evaluates.add(0f);
        }

        if (position != null){

            for (int i = 0; i < position.size(); i++) {

                Position position = this.position.get(i);
                Float f = evaluates.get(i);
                if (f == 1.0f){
                    position.setType(ALL);
                }else if (f == 0.5f){
                    position.setType(OTHER);
                }
            }
        }
        invalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (!touch){
            return super.onTouchEvent(event);
        }
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
        down(x,y);
    }

    private void up(float x, float y) {

    }

    private void down(float x, float y) {
        if (position == null || position.isEmpty()){
            return;
        }
        for (Position p : position) {
            if (x >= p.getX()+radius){
                p.setType(ALL);
                p.setChecked(true);
            }else if (x >= p.getX() && x <= p.getX()+radius){
                p.setChecked(true);
                p.setType(ALL);
            }else if (x >= p.getX()-radius && x < p.getX()){
                p.setChecked(true);
                p.setType(OTHER);
            }else{
                p.setChecked(false);
            }
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);

        int defaultSize = DensityUtil.dp2px(40);
        int defaultWidthSize = getResources().getDisplayMetrics().widthPixels/3;
//        int defaultWidthSize = DensityUtil.dp2px(200);
        if (widthMeasureMode == MeasureSpec.AT_MOST && heightMeasureMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(defaultWidthSize,defaultSize);
        }else if (widthMeasureMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultWidthSize,heightMeasureSpec);
        }else if (heightMeasureMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthMeasureSpec,defaultSize);
        }
        float width = getWidth();
        float height = getHeight();
        position = position(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (position != null){
            for (Position po : position) {

                Position a = new Position(po.getX(),po.getY() - radius);
                Position b = new Position(po.getX()+cos(270-72),po.getY()+sin(180+18));
                Position c = new Position(po.getX()+cos(270-72*2),po.getY()+sin(90+18));
                Position d = new Position(po.getX()+cos(270-72*3),po.getY()+sin(72));
                Position e = new Position(po.getX()+cos(270-72*4),po.getY()+sin(-18));
                Position f = positionXY(b,c,d,e);
                Position g = positionXY(a,b,c,d);
                Position h = positionXY(a,b,c,e);
                Position i = positionXY(a,b,d,e);
                Position j = positionXY(a,c,d,e);

                Position k = new Position((2*a.getX()+h.getX())/3,(2*a.getY()+h.getY())/3);
                Position l = new Position((2*i.getX()+a.getX())/3,(2*i.getY()+a.getY())/3);

                Position m = new Position((2*b.getX()+h.getX())/3,(2*b.getY()+h.getY())/3);
                Position n = new Position((2*g.getX()+b.getX())/3,(2*g.getY()+b.getY())/3);

                Position o = new Position((2*c.getX()+g.getX())/3,(2*c.getY()+g.getY())/3);
                Position p = new Position((2*f.getX()+c.getX())/3,(2*f.getY()+c.getY())/3);

                Position q = new Position((2*d.getX()+f.getX())/3,(2*d.getY()+f.getY())/3);
                Position r = new Position((2*j.getX()+d.getX())/3,(2*j.getY()+d.getY())/3);

                Position s = new Position((2*e.getX()+j.getX())/3,(2*e.getY()+j.getY())/3);
                Position t = new Position((2*i.getX()+e.getX())/3,(2*i.getY()+e.getY())/3);

                Path path = new Path();

                path.moveTo(l.getX(),l.getY());
                path.quadTo(a.getX(),a.getY(),k.getX(),k.getY());
                path.lineTo(h.getX(),h.getY());
                path.lineTo(m.getX(),m.getY());
                path.quadTo(b.getX(),b.getY(),n.getX(),n.getY());

                path.lineTo(g.getX(),g.getY());
                path.lineTo(o.getX(),o.getY());
                path.quadTo(c.getX(),c.getY(),p.getX(),p.getY());
                path.lineTo(f.getX(),f.getY());
                path.lineTo(q.getX(),q.getY());
                path.quadTo(d.getX(),d.getY(),r.getX(),r.getY());
                path.lineTo(j.getX(),j.getY());
                path.lineTo(s.getX(),s.getY());
                path.quadTo(e.getX(),e.getY(),t.getX(),t.getY());
                path.lineTo(i.getX(),i.getY());
                path.close();
                if (po.isChecked()){
                    if (po.getType() == ALL){
                        paint.setColor(Color.parseColor("#fdad00"));
                    }else if (po.getType() ==OTHER){

                        paint.setColor(Color.parseColor("#d1d1d1"));
                        canvas.drawPath(path,paint);
                        Position u = new Position(a.getX(),(k.getY() + a.getY())/2);
                        Path pp = new Path();
                        pp.moveTo(f.getX(),f.getY());
                        pp.lineTo(u.getX(),u.getY());
                        pp.quadTo((a.getX() + k.getX())/2,u.getY(),k.getX(),k.getY());
                        pp.lineTo(h.getX(),h.getY());
                        pp.lineTo(m.getX(),m.getY());
                        pp.quadTo(b.getX(),b.getY(),n.getX(),n.getY());
                        pp.lineTo(g.getX(),g.getY());
                        pp.lineTo(o.getX(),o.getY());
                        pp.quadTo(c.getX(),c.getY(),p.getX(),p.getY());
                        pp.close();
                        paint.setColor(Color.parseColor("#fdad00"));
                        canvas.drawPath(pp,paint);
                        continue;
                    }

                }else{
                    paint.setColor(Color.parseColor("#d1d1d1"));
                }
                canvas.drawPath(path,paint);
//                path.reset();

            }
        }
    }

    private Position positionXY(Position b,Position c,Position d,Position e){

        float A = (b.getY() - d.getY())/(b.getX() - d.getX());
        float B = b.getY() - b.getX()*A;

        float C = (c.getY() - e.getY())/(c.getX() - e.getX());
        float D = c.getY() - c.getX()*C;


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
        if (evaluates != null){
            for (int i = 0; i < startNum; i++) {

                Position p = new Position();
                p.setX(startX+v*i);
                p.setY(startY);
                Float f = evaluates.get(i);
                if (f == 1.0f){
                    p.setChecked(true);
                    p.setType(ALL);
                }else if (f == 0.5f){
                    p.setChecked(true);
                    p.setType(OTHER);
                }else{
                    p.setChecked(false);
                }
                data.add(p);
            }
        }else{
            for (int i = 0; i < startNum; i++) {

                Position p = new Position();
                p.setX(startX+v*i);
                p.setY(startY);
                data.add(p);
            }
        }

        return data;
    }

    public float getEvaluateCount(){

        if (position == null || position.isEmpty()){
            return 0;
        }
        float count = 0;
        for (Position p : position) {

            if (p.isChecked()){
                count++;
            }
        }

        return count;
    }
    class Position{

        private float x;
        private float y;
        private boolean checked;
        private int type;
        public Position(){

        }
        public Position(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
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
