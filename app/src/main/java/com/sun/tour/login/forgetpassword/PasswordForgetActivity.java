package com.sun.tour.login.forgetpassword;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

@Route(path = Constant.ACTVIITY_ROUTE+"/login/forgetpassword/passwordforget_activity")
public class PasswordForgetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forget);
        init();
    }

    private void init() {
        setTopTitle("忘记密码");
    }
}
