package com.sun.tour.store;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sun.tour.OnRecyclerViewItemClick;
import com.sun.tour.R;
import com.sun.tour.base.BaseFragment;
import com.sun.tour.store.adapter.StoreAdapter;
import com.sun.tour.utils.Constant;

import butterknife.BindView;

public class StoreFragment extends BaseFragment {

    @BindView(R.id.refresh_layout_store)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerView_store)
    RecyclerView mRecyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private StoreAdapter mStoreAdapter;


    public StoreFragment() {
        // Required empty public constructor
    }

    public static StoreFragment newInstance(String param1, String param2) {
        StoreFragment fragment = new StoreFragment();
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
        return R.layout.fragment_store;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getHoldingActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mStoreAdapter = new StoreAdapter();
        mRecyclerView.setAdapter(mStoreAdapter);
        mStoreAdapter.setOnRecyclerViewItemClick(new OnRecyclerViewItemClick() {
            @Override
            public void onItemRecyclerViewClick(int position) {
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/store/store_edit/storeedit_acitivity").navigation(getActivity());
            }
        });
    }


}
