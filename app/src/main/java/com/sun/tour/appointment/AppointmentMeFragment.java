package com.sun.tour.appointment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sun.tour.R;
import com.sun.tour.appointment.adapter.AppointmentMineAdapter;
import com.sun.tour.appointment.adapter.MyAppointmentAdapter;
import com.sun.tour.base.BaseFragment;

import butterknife.BindView;

public class AppointmentMeFragment extends BaseFragment {

    @BindView(R.id.refresh_layout_my_appointment)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.recyclerview_my_appiontment)
    RecyclerView mRecyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public AppointmentMeFragment() {

    }

    public static AppointmentMeFragment newInstance(String param1, String param2) {
        AppointmentMeFragment fragment = new AppointmentMeFragment();
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
        return R.layout.fragment_my_appointment;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getHoldingActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new AppointmentMineAdapter());
    }


}
