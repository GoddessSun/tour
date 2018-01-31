package com.sun.tour.appointment.evaluate;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;
import com.sun.tour.view.StarView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 预约评价
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/appointment/evaluate/evaluate_activity")
public class EvaluateActivity extends BaseActivity {

    @BindView(R.id.starview)
    StarView starview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        setTopTitle("评价");
        starview.setEvaluate(5,3.1f);
    }
}
