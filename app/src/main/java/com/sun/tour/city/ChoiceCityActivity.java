package com.sun.tour.city;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

@Route(path = Constant.ACTVIITY_ROUTE+"/city/choicecity_activity")
public class ChoiceCityActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_city);
        init();
    }

    private void init() {
        setTitle("选择位置");
        ChoiceCityFragment fragment = new ChoiceCityFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.choice_city_fragment_layout,fragment).commit();
    }
}
