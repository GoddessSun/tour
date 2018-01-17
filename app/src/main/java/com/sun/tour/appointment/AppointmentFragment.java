package com.sun.tour.appointment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.sun.tour.R;
import com.sun.tour.TabEntity;
import com.sun.tour.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AppointmentFragment extends BaseFragment implements OnTabSelectListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.tablayout_appointment)
    CommonTabLayout mCommonTabLayout;
    @BindView(R.id.viewpager_appointment)
    ViewPager mViewPager;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private String[] mTitles = {"我的预约", "预约我的"};
    private List<Fragment> mFragments;
    private ArrayList<CustomTabEntity> mTabEntities;

    public AppointmentFragment() {
        // Required empty public constructor
    }

    public static AppointmentFragment newInstance(String param1, String param2) {
        AppointmentFragment fragment = new AppointmentFragment();
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
        return R.layout.fragment_appointment;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {
        mTabEntities = new ArrayList<>();
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new AppiontmentTabEntry(mTitles[i]));
        }
        mFragments.add(MyAppointmentFragment.newInstance("", ""));
        mFragments.add(AppointmentMeFragment.newInstance("", ""));
        mCommonTabLayout.setTabData(mTabEntities);
        mCommonTabLayout.setOnTabSelectListener(this);
        mViewPager.setAdapter(new MyPagerAdapter(getHoldingActivity().getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onTabSelect(int position) {
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onTabReselect(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mCommonTabLayout.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
