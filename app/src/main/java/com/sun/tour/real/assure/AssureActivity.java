package com.sun.tour.real.assure;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

@Route(path = Constant.ACTVIITY_ROUTE+"/real/assure/assure_activity")
public class AssureActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assure);
        init();
    }

    private void init() {

        setTopTitle("担保");
    }
}
