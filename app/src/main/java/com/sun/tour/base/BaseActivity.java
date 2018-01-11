package com.sun.tour.base;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.tour.R;
import com.sun.tour.utils.SystemStatueBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTitleTextView;
    FrameLayout mFrameLayoutLeft; //左侧返回按钮，默认状态显示
    FrameLayout mFrameLayoutRight;//右侧小标题按钮，默认状态不显示
    private Unbinder mUnbinder;
    private long exitTime = 0;
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
    public void setContentView(int layoutResID) {
        if (useOwnContentView()){//使用自定义布局
            super.setContentView(layoutResID);
        }else {//使用默认布局
            SystemStatueBarUtil.setStatusBarLightMode(this, Color.parseColor("#ffffff"));
            LayoutInflater inflater = LayoutInflater.from(this);
            ViewGroup mRootView = (ViewGroup) inflater.inflate(R.layout.activity_base, null);
            LayoutInflater.from(this).inflate(layoutResID,mRootView);
            mTitleTextView = mRootView.findViewById(R.id.text_toolbar_title);
            mFrameLayoutLeft = mRootView.findViewById(R.id.framelayout_left_base);
            mFrameLayoutLeft.setOnClickListener(this);
            mFrameLayoutRight = mRootView.findViewById(R.id.framelayout_right_base);
            super.setContentView(mRootView);
        }
        mUnbinder = ButterKnife.bind(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.framelayout_left_base://左侧返回按钮点击事件
                onBackPressed();
                break;
        }
    }
}
