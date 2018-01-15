package com.sun.tour.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;

import butterknife.BindView;

@Route(path = "/tour/login/login_activity")
public class LoginActivity extends BaseActivity {

    @BindView(R.id.edit_phone)
    EditText mPhoneEditView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTopTitle("登录");
    }
}
