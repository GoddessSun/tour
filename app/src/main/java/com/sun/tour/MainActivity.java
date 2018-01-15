package com.sun.tour;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.sun.tour.appointment.AppointmentFragment;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.focus.FocusFragment;
import com.sun.tour.home.HomeFragment;
import com.sun.tour.message.MessageFragment;
import com.sun.tour.store.StoreFragment;
import com.sun.tour.utils.SystemStatueBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 *
 * shouye
 */
@Route(path = "/tour/main/main_activity")
public class MainActivity extends BaseActivity implements OnTabSelectListener,ViewPager.OnPageChangeListener{

    @BindView(R.id.viewpager_main)
    ViewPager mViewPager;
    @BindView(R.id.tablayout_main)
    CommonTabLayout mCommonTabLayout;
    private String[] mTitles = {"首页","关注","消息","预约","店铺"};
    private int[] mUnSelected = {R.drawable.ic_home_normal,R.drawable.ic_focus_normal,R.drawable.ic_message_normal,R.drawable.ic_appointment_normal,R.drawable.ic_store_normal};
    private int[] mSelected = {R.drawable.ic_home_selected,R.drawable.ic_focus_selected,R.drawable.ic_message_selected,R.drawable.ic_appointment_selected,R.drawable.ic_store_selected};
    private List<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemStatueBarUtil.setStatusBarLightMode(this, Color.parseColor("#ffffff"));
        mFragments.add(HomeFragment.newInstance("",""));
        mFragments.add(FocusFragment.newInstance("",""));
        mFragments.add(MessageFragment.newInstance("",""));
        mFragments.add(AppointmentFragment.newInstance("",""));
        mFragments.add(StoreFragment.newInstance("",""));
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(this);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i],mSelected[i],mUnSelected[i]));
        }
        mCommonTabLayout.setTabData(mTabEntities);
        mCommonTabLayout.setOnTabSelectListener(this);

        //显示未读红点
        mCommonTabLayout.showDot(4);
        //两位数
        mCommonTabLayout.showMsg(2, 55);
        mCommonTabLayout.setMsgMargin(2, -5, 5);
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


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            exit();
        }
        return false;
    }
}
