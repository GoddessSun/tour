package com.sun.tour.appointment;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Date: 2018/1/17
 * Time: 14:24
 * author: sunmingmao
 */

public class AppiontmentTabEntry implements CustomTabEntity {
    public String title;

    public AppiontmentTabEntry(String title) {
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
