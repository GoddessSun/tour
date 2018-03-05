package com.sun.tour;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.utils.SharedPrefUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
@Route(path = "/tour/main/guide_activity")
public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.viewpager_guide)
    ViewPager mViewPager;
    private Unbinder unbinder;
    private List<View> mImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        unbinder = ButterKnife.bind(this);

        LayoutInflater inflater = LayoutInflater.from(this);

        //把引导页加入到集合中
        mImageList.add(inflater.inflate(R.layout.view_guide_01, null));
        mImageList.add(inflater.inflate(R.layout.view_guide_02, null));
        mImageList.add(inflater.inflate(R.layout.view_guide_03, null));
        mImageList.add(inflater.inflate(R.layout.view_guide_04, null));

        GuidePagerAdapter guidePagerAdapter = new GuidePagerAdapter(mImageList, this);
        mViewPager.setAdapter(guidePagerAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public class GuidePagerAdapter extends PagerAdapter {
        private List<View> views;
        private Activity activity;

        public GuidePagerAdapter(List<View> views, Activity activity) {
            this.views = views;
            this.activity = activity;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public int getCount() {
            return (views == null) ? 0 : views.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position), 0);
            //当滑动到最后一页的时候，监听按钮
            if (position == views.size() - 1) {
                TextView tvEnter = (TextView) container.findViewById(R.id.tv_guide_enter);
                tvEnter.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPrefUtil.putBoolean(SharedPrefUtil.SP_IS_FIRST_LOGIN,false);
                        ARouter.getInstance().build("/tour/login/login_activity").navigation();
                        GuideActivity.this.finish();
                    }
                });
            }
            return views.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return (arg0 == arg1);
        }
    }
}
