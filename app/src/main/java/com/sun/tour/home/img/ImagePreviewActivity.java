package com.sun.tour.home.img;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;
import com.sun.tour.view.PointView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = Constant.ACTVIITY_ROUTE + "/home/img/imagepreview_activity")
public class ImagePreviewActivity extends BaseActivity {

    @BindView(R.id.test_viewpager)
    ViewPager vp;
    @BindView(R.id.preview_point_v)
    PointView pointView;
    private List<Fragment> data = new ArrayList<>();
    private ArrayList<String> selected;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image_preview);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {
        getBundleData();
        if (selected == null){
            return;
        }
        for (int i = 0; i < selected.size(); i++) {
            ImagePreviewFragment fragment = new ImagePreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("path",selected.get(i));
            fragment.setArguments(bundle);
            data.add(fragment);
        }
        ImagePreviewAdapter mAdapter = new ImagePreviewAdapter(getSupportFragmentManager(),data);
        vp.setAdapter(mAdapter);
        vp.setCurrentItem(position);
        pointView.setTotalCount(data.size());
        pointView.setSelectItem(vp.getCurrentItem());
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                pointView.setSelectItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void getBundleData(){

        Bundle extras = getIntent().getExtras();
        selected = extras.getStringArrayList("selected");
        position = extras.getInt("position",0);
    }
}
