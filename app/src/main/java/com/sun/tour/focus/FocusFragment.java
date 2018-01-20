package com.sun.tour.focus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sun.tour.OnRecyclerViewItemClick;
import com.sun.tour.R;
import com.sun.tour.base.BaseFragment;
import com.sun.tour.focus.adapter.FocusAdapter;
import com.sun.tour.focus.callback.OnItemCancleClick;
import com.sun.tour.view.RxToast;

import butterknife.BindView;
import butterknife.OnClick;


public class FocusFragment extends BaseFragment implements OnItemCancleClick,OnRecyclerViewItemClick{

    @BindView(R.id.recyclerView_focus)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout_focus)
    SmartRefreshLayout mRefreshLayout;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FocusAdapter mFocusAdapter;


    public FocusFragment() {
        // Required empty public constructor
    }

    public static FocusFragment newInstance(String param1, String param2) {
        FocusFragment fragment = new FocusFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_focus;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getHoldingActivity(),2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mFocusAdapter = new FocusAdapter();
        mRecyclerView.setAdapter(mFocusAdapter);
        mFocusAdapter.setOnItemCancleClick(this);
        mFocusAdapter.setOnRecyclerViewItemClick(this);
    }


    @Override
    public void onCancleClick(int position) {
        RxToast.info("取消关注:"+position);
    }

    @Override
    public void onItemRecyclerViewClick(int position) {
        RxToast.info("Click:"+position);
    }
}
