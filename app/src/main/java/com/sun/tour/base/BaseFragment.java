package com.sun.tour.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseFragment} factory method to
 * create an instance of this fragment.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    /*缓存Fragment view*/
    private ViewGroup mRootView;
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasLoadedData; // 标识已经触发过懒加载数据
    private Unbinder unbinder;
    /*视图构造器*/
    private LayoutInflater mInflater;

    /**
     * 此方法用于返回Fragment设置ContentView的布局文件资源ID
     *
     * @return 布局文件资源ID
     */
    @LayoutRes
    public abstract int getLayoutId();

    /**
     * 此方法用于在fragment数据的初始化(懒加载)
     */
    protected abstract void lazyLoadData();

    /**
     * 此方法用于初始化Fragment布局文件资源
     */
    public abstract void initViews(View rootView);

    /**
     * 是否有标题栏
     */
    @NonNull
    public boolean isHadNormalTitleBar() {
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        initViews(mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewPrepared = true;
        lazyLoadDataIfPrepared();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        // view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始
        hasLoadedData = false;
        isViewPrepared = false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared();
        }
    }

    private void lazyLoadDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasLoadedData && isViewPrepared) {
            hasLoadedData = true;
            lazyLoadData();
        }
    }

    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    public String getName() {
        return getClass().getSimpleName();
    }



}
