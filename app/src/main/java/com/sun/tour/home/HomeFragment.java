package com.sun.tour.home;


import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sun.tour.R;
import com.sun.tour.base.BaseFragment;
import com.sun.tour.home.adapter.NearbyAdapter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.refresh_layout_home)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.scrollView_home)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.recyclerview_nearby_home)
    RecyclerView mNearbyRecyclerView;
    @BindView(R.id.recyclerview_hot_home)
    RecyclerView mHotRecyclerView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {
        mSmartRefreshLayout.setEnableLoadmore(false);
        LinearLayoutManager mNearbyLinearLayoutManager = new LinearLayoutManager(getHoldingActivity());
        mNearbyLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mNearbyRecyclerView.setLayoutManager(mNearbyLinearLayoutManager);

        LinearLayoutManager mHotLinearLayoutManager = new LinearLayoutManager(getHoldingActivity());
        mHotLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHotRecyclerView.setLayoutManager(mHotLinearLayoutManager);

        NearbyAdapter nearbyAdapter = new NearbyAdapter();
        mNearbyRecyclerView.setAdapter(nearbyAdapter);

        mHotRecyclerView.setAdapter(nearbyAdapter);
    }




}
