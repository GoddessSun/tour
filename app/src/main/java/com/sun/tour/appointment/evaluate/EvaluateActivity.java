package com.sun.tour.appointment.evaluate;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

/**
 *
 *
 * 预约评价
 *
 */
@Route(path = Constant.ACTVIITY_ROUTE+"/appointment/evaluate/evaluate_activity")
public class EvaluateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        init();
    }

    private void init() {

        setTitle("评价");
    }
}
