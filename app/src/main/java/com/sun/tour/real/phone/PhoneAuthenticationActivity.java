package com.sun.tour.real.phone;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;
import java.util.List;

@Route(path = Constant.ACTVIITY_ROUTE+"/real/phone/phoneauthentication_activity")
public class PhoneAuthenticationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_authentication);
        init();
    }

    private void init() {
        setTopTitle("电话认证");

    }
}
