package com.sun.tour.home.subscribe;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

/**
 *
 *
 * 预约
 */
@Route(path = Constant.ACTVIITY_ROUTE+"/home/subscribe/subscribe_activity")
public class SubscribeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        init();
    }

    private void init() {

        setTopTitle("预约");
    }
}
