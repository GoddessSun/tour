package com.sun.tour.home.img;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hanyg on 2018/2/6.
 */

public class ImagePreviewAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    public ImagePreviewAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
