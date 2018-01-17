package com.sun.tour.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.sun.tour.R;
import com.sun.tour.view.LoadingIndicatorView.LoadingIndicatorView;


/**
 * Created by kunpeng on 2016/6/14.
 */
public class MyProgressDialog extends Dialog {


    private TextView mContentTxt;
    private LoadingIndicatorView mLoadView;

    public MyProgressDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        this(context, null, cancelable, cancelListener);
    }

    public MyProgressDialog(@NonNull Context context, String content, boolean cancelable, OnCancelListener cancelListener) {
        super(context, R.style.SdkDialogLoadingStyle);
        setContentView(R.layout.dialog_loading);
        setCancelable(cancelable);
        setOnCancelListener(cancelListener);
        setCanceledOnTouchOutside(false);
        mContentTxt = (TextView) findViewById(R.id.txt_loading_content);// 提示文字
        mLoadView = (LoadingIndicatorView) findViewById(R.id.load_view);
        if (mLoadView != null && mLoadView.getVisibility() == View.VISIBLE) {
            mLoadView.smoothToShow();
        }
        if (!TextUtils.isEmpty(content)) {
            setContent(content);
        }
    }

    public void setContent(String content) {
        if (null != mContentTxt) {
            mContentTxt.setText(content);// 设置加载信息
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mLoadView != null) {
            mLoadView.smoothToHide();
        }
    }
}
