package com.sun.tour.store.price;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

@Route(path = Constant.ACTVIITY_ROUTE+"/store/price/price_activity")
public class PriceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        init();
    }

    private void init() {

    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }
}
