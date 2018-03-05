package com.sun.tour.setting;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.config.UserConfig;
import com.sun.tour.utils.Constant;
import com.sun.tour.utils.SharedPrefUtil;

import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE+"/setting/setting_activity")
public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }

    private void init() {
        setTopTitle("设置");

    }

    @OnClick(R.id.btn_out_login)
    public void onOutLogin(){
        UserConfig.setLogin(false);
        finish();
    }


}
