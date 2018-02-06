package com.sun.tour.home.subscribe;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.store.dialog.SortDialogUtil;
import com.sun.tour.utils.Constant;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 预约
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/home/subscribe/subscribe_activity")
public class SubscribeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        setTopTitle("预约");
    }

    @OnClick({R.id.subscribe_hotal_compute_cost_layout,R.id.subscribe_hotal_start_time_set_tv,R.id.subscribe_hotal_end_time_set_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.subscribe_hotal_compute_cost_layout:
                SortDialogUtil.showComputeCostDialog(this);
                break;
            case R.id.subscribe_hotal_start_time_set_tv:
                SortDialogUtil.showDate_TimeDialog(this);
                break;
            case R.id.subscribe_hotal_end_time_set_tv:
                SortDialogUtil.showDate_TimeDialog(this);
                break;
        }
    }
}
