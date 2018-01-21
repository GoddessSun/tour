package com.sun.tour;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.sun.tour.appointment.AppointmentFragment;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.focus.FocusFragment;
import com.sun.tour.home.HomeFragment;
import com.sun.tour.message.MessageFragment;
import com.sun.tour.store.StoreFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 *
 *
 * shouye
 */
@Route(path = "/tour/main/main_activity")
public class MainActivity extends BaseActivity implements OnTabSelectListener
        ,ViewPager.OnPageChangeListener
        ,View.OnClickListener{

    @BindView(R.id.viewpager_main)
    ViewPager mViewPager;
    @BindView(R.id.tablayout_main)
    CommonTabLayout mCommonTabLayout;
    @BindView(R.id.drawerlayout_main)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigationView_main)
    NavigationView mNavigationView;
    private String[] mTitles = {"首页","关注","消息","预约","店铺"};
    private int[] mUnSelected = {R.drawable.ic_home_normal,R.drawable.ic_focus_normal,R.drawable.ic_message_normal,R.drawable.ic_appointment_normal,R.drawable.ic_store_normal};
    private int[] mSelected = {R.drawable.ic_home_selected,R.drawable.ic_focus_selected,R.drawable.ic_message_selected,R.drawable.ic_appointment_selected,R.drawable.ic_store_selected};
    private List<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
            private View mDrawerLayoutView;
    private LinearLayout mNoLoginView;
    private RelativeLayout mLoginRealtiveLayout;
    private CircleImageView mUserIcon;
    private TextView mUserNameTextView;
    private TextView mUserSignTextView;

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.transparencyBar(this);
        StatusBarUtil.StatusBarLightMode(this);

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
        //左侧侧滑布局
        initDrawerLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mDrawerLayoutView = mNavigationView.inflateHeaderView(R.layout.layout_persion_center);
        mNoLoginView = mDrawerLayoutView.findViewById(R.id.linear_no_login);
        mLoginRealtiveLayout = mDrawerLayoutView.findViewById(R.id.relative_logined);
        mUserIcon = mDrawerLayoutView.findViewById(R.id.circle_image_user_icon);
        mUserNameTextView = mDrawerLayoutView.findViewById(R.id.text_main_user_name);
        mUserSignTextView = mDrawerLayoutView.findViewById(R.id.text_main_user_sign);
        mDrawerLayoutView.findViewById(R.id.text_persion_info).setOnClickListener(this);
        mDrawerLayoutView.findViewById(R.id.text_authy).setOnClickListener(this);
        mDrawerLayoutView.findViewById(R.id.text_notiycation).setOnClickListener(this);
        mDrawerLayoutView.findViewById(R.id.text_help).setOnClickListener(this);
        mDrawerLayoutView.findViewById(R.id.text_setting).setOnClickListener(this);
        mDrawerLayoutView.findViewById(R.id.text_login_register).setOnClickListener(this);
        mUserIcon.setOnClickListener(this);
        mUserSignTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_persion_info://个人信息
                ARouter.getInstance().build("/tour/persion/persion_center_activity").navigation();
                break;
            case R.id.text_authy://认证
                ARouter.getInstance().build("/tour/real/real_activity").navigation();
                break;
            case R.id.text_notiycation://系统通知
                break;
            case R.id.text_help://帮助
                break;
            case R.id.text_setting://设置
                break;
            case R.id.text_login_register://登录
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public DrawerLayout getPersionDrawerLayout(){
        return mDrawerLayout;
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
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                exit();
            }
        }
        return false;
    }
}
