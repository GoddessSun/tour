package com.sun.tour.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.sun.tour.R;

/**
 * Created by hanyg on 2018/2/1.
 */

public class SortView extends View {

    public static final int DEFAULT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    private Context context;
    private String text;
    private float textSize;
    private int textColor;
    private int sort;
    private boolean showSortIcon;
    private boolean showBottomLine;
    private int lineColor;
    private float lineHeight;
    private Paint paint;
    private int magin;
    private boolean checked;
    public SortView(Context context) {
        super(context);
    }

    public SortView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }



    public SortView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {

        this.context = context;
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.SortView);
        text = arr.getString(R.styleable.SortView_sText);
        textSize = arr.getDimension(R.styleable.SortView_sTextSize,14);
        textColor = arr.getColor(R.styleable.SortView_sTextColor, context.getResources().getColor(R.color.text_color333));
        sort = arr.getInt(R.styleable.SortView_sort, DEFAULT);
        showSortIcon = arr.getBoolean(R.styleable.SortView_showSortIcon, false);
        showBottomLine = arr.getBoolean(R.styleable.SortView_showBottomLine, false);
        lineColor = arr.getColor(R.styleable.SortView_lineColor, context.getResources().getColor(R.color.blue43));
        lineHeight = arr.getDimension(R.styleable.SortView_lineHeight, context.getResources().getDimension(R.dimen.base_line_height));
        checked = arr.getBoolean(R.styleable.SortView_checked,false);
        magin = DensityUtil.dp2px(5);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public int getSort() {
        return sort;
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        invalidate();
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
    }

    public void setSort(int sort) {
        this.sort = sort;
        invalidate();
    }

    public void setShowSortIcon(boolean showSortIcon) {
        this.showSortIcon = showSortIcon;
        invalidate();
    }

    public void setShowBottomLine(boolean showBottomLine) {
        this.showBottomLine = showBottomLine;
        invalidate();
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        invalidate();
    }

    public void setChecked(boolean checked) {
//        if (this.checked == checked){
//            return;
//        }
        this.checked = checked;
        setShowBottomLine(checked);
    }

    public void setLineHeight(float lineHeight) {
        this.lineHeight = lineHeight;
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        if (!TextUtils.isEmpty(text)){
            paint.setTextSize(textSize);
            Rect textRect = new Rect();
            paint.getTextBounds(text,0,text.length(),textRect);
            paint.setColor(textColor);
            canvas.drawText(text,width/2 - textRect.width()/2,height/2+textRect.height()/2 ,paint);
            float w = textRect.width();
            if (showSortIcon){
                Bitmap bt = null;
                switch (sort){
                    case UP:
                        bt = BitmapFactory.decodeResource(getResources(),R.drawable.vector_sort_up);
                        break;
                    case DOWN:
                        bt = BitmapFactory.decodeResource(getResources(),R.drawable.vector_sort_down);
                        break;
                    default:
                        bt = BitmapFactory.decodeResource(getResources(),R.drawable.vector_sort_default);
                        break;
                }
                w += magin+bt.getWidth();
                canvas.drawBitmap(bt,width/2+textRect.width()/2+magin,height/2 - bt.getHeight()/2,null);

            }
            if (showBottomLine){

                paint.setColor(lineColor);
                canvas.drawLine(width/2-textRect.width()/2,height - 1,width/2-textRect.width()/2+w,height - 1,paint);
            }
        }
    }

}
