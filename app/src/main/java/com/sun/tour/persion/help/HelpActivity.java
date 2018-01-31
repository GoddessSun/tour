package com.sun.tour.persion.help;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

/**
 *
 *
 * 帮助中心
 *
 */
@Route(path = Constant.ACTVIITY_ROUTE+"/persion/help/help_activity")
public class HelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        init();
    }

    private void init() {
        setTopTitle("帮助中心");
    }
}
