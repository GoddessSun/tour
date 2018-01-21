package com.sun.tour.real;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;

import butterknife.OnClick;

@Route(path = "/tour/real/real_activity")
public class RealActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        setTopTitle("认证");
    }

    @OnClick(R.id.linear_real_persion)//个人身份
    public void onPersionalClick(){

    }

    @OnClick(R.id.linear_real_phone)//电话认证
    public void onPhoneClick(){

    }

    @OnClick(R.id.linear_real_other)//其他认证
    public void onOtherClick(){

    }

    @OnClick(R.id.linear_real_promiss_real)//担保认证
    public void onRealPromissClick(){

    }


    @OnClick(R.id.linear_real_promiss)//担保
    public void onPromissClick(){

    }
}
