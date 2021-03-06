package com.sun.tour.base;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.tour.R;
import com.sun.tour.event.BaseEvent;
import com.sun.tour.utils.SystemStatueBarUtil;
import com.sun.tour.view.MyProgressDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity{

    TextView mTitleTextView;
    FrameLayout mFrameLayoutLeft; //左侧返回按钮，默认状态显示
    FrameLayout mFrameLayoutRight;//右侧小标题按钮，默认状态不显示
    private Unbinder mUnbinder;
    private long exitTime = 0;
    private MyProgressDialog myProgressDialog;
    private ImageView mRightImageView;
    private TextView mRightTextView;
    private boolean show;
    private int color = -1;

    /**
     * 是否使用自己的布局，即不适用默认的toolbar以及默认的toolbar+content布局
     *
     * @return true:使用自己的布局；false:不使用，即使用默认的toolbar+content布局
     * 默认是false
     */
    public boolean useOwnContentView() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void setContentView(int layoutResID) {

        int color = Color.parseColor("#ffffff");
        if (this.color != -1){
            color = this.color;
        }
        if (useOwnContentView()){//使用自定义布局
            super.setContentView(layoutResID);
            if (!show){
                SystemStatueBarUtil.setStatusBarLightMode(this, color);
            }
        }else {//使用默认布局
            SystemStatueBarUtil.setStatusBarLightMode(this, color);
            LayoutInflater inflater = LayoutInflater.from(this);
            ViewGroup mRootView = (ViewGroup) inflater.inflate(R.layout.activity_base, null);
            LayoutInflater.from(this).inflate(layoutResID,mRootView);
            mTitleTextView = mRootView.findViewById(R.id.text_toolbar_title);
            mFrameLayoutLeft = mRootView.findViewById(R.id.framelayout_left_base);
            mFrameLayoutLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
            mFrameLayoutRight = mRootView.findViewById(R.id.framelayout_right_base);
            mRightImageView = mRootView.findViewById(R.id.image_base_right);
            mRightTextView = mRootView.findViewById(R.id.text_base_small_title);
            mFrameLayoutRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRightMenuClick();
                    onRightMenuClick(mRightTextView);
                }
            });
            super.setContentView(mRootView);
        }

        mUnbinder = ButterKnife.bind(this);
    }

    public void setContentView(int layoutResID,int color){

        this.color = color;
        setContentView(layoutResID);
    }

    protected void setContentView(int layoutResID,boolean show){
        this.show = show;
        setContentView(layoutResID);
    }
    /**
     * 设置标题
     * @param defaultTitle
     */
    public void setTopTitle(@NonNull String defaultTitle){
        mTitleTextView.setText(defaultTitle);
    }

    /**
     * 设置左侧按钮是否可见 ，默认状态可见
     * @param isVisible
     */
    public void setLeftVisibility(int isVisible){
        mFrameLayoutLeft.setVisibility(isVisible);
    }

    /**
     * 设置左侧按钮是否可见 ，默认状态可见
     * @param isVisible
     */
    public void setRightVisibility(int isVisible){
        mFrameLayoutRight.setVisibility(isVisible);
    }

    /**
     * 设置右侧小标题 文字
     * @param rightText
     */
    public void setRightText(String rightText){
        mFrameLayoutRight.setVisibility(View.VISIBLE);
        mRightImageView.setVisibility(View.GONE);
        mRightTextView.setVisibility(View.VISIBLE);
        mRightTextView.setText(rightText);
    }

    /**
     * 设置右侧图标按钮
     * @param id
     */
    public void setRightImageView(int id){
        mFrameLayoutRight.setVisibility(View.VISIBLE);
        mRightImageView.setVisibility(View.VISIBLE);
        mRightTextView.setVisibility(View.GONE);
        mRightImageView.setImageResource(id);
    }

    public TextView getRightTextView(){
        return mRightTextView;
    }

    public ImageView getRightImageView(){
        return mRightImageView;
    }
    /**
     * 右侧如果有点击事件 重写该方法
     */
    protected void onRightMenuClick() {
    }
    /**
     * 右侧如果有点击事件 重写该方法
     */
    protected void onRightMenuClick(TextView rightTextView) {
    }

    /**
     * 更新loading信息
     * @param message
     */
    public void updateLoading(String message) {
        if (myProgressDialog != null && myProgressDialog.isShowing()) {
            myProgressDialog.setContent(message);
        }
    }

    /**
     * 默认显示 正在加载...
     */
    public void showLoading() {
        showLoading("", false, null);
    }

    /**
     *
     * @param message loading显示内容
     */
    public void showLoading(String message) {
        showLoading(message, false, null);
    }

    /**
     *
     * @param content loading显示内容
     * @param cancelable 是否允许点击外部删除
     */
    public void showLoading(String content, boolean cancelable) {
        showLoading(content, cancelable, null);
    }

    /**
     *
     * @param content loading显示内容
     * @param cancelable 是否允许点击外部删除
     * @param onCancelListener  删除监听
     */
    public void showLoading(String content, boolean cancelable, DialogInterface.OnCancelListener onCancelListener) {
        if (myProgressDialog != null) {
            myProgressDialog.cancel();
            myProgressDialog = null;
        }
        myProgressDialog = new MyProgressDialog(this, content, cancelable, onCancelListener);
        myProgressDialog.show();
    }

    /**
     * 删除loading
     */
    public void dismissLoading() {
        if (myProgressDialog != null) {
            //调用此函数的一般都是正常结束的并非返回引起，所以，设置监听为空
            myProgressDialog.setOnCancelListener(null);
            myProgressDialog.cancel();
            myProgressDialog = null;
        }
    }
    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), R.string.main_backpress_exit,
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onBaseEvent(BaseEvent baseEvent){

    }


}
