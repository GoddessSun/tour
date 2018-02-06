package com.sun.tour.persion.authentication.assure_authentication;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

@Route(path = Constant.ACTVIITY_ROUTE+"/persion/authentication/assure_authentication/assureauthentication_activity")
public class AssureAuthenticationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assure_authentication);
        init();
    }

    private void init() {
        setTopTitle("担保认证");
    }
}
