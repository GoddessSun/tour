package com.sun.tour.real;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.OnClick;

@Route(path = "/tour/real/real_activity")
public class RealActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        setTopTitle("认证");
    }
    @OnClick({R.id.linear_real_persion,R.id.linear_real_phone,R.id.linear_real_other,
            R.id.linear_real_promiss_real,R.id.linear_real_promiss})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.linear_real_persion://个人身份
                toActivity(Constant.ACTVIITY_ROUTE + "/real/identity_person_activity",0);
                break;
            case R.id.linear_real_phone://电话认证
                toActivity(Constant.ACTVIITY_ROUTE+"/real/phone/phoneauthentication_activity",0);
                break;
            case R.id.linear_real_other://其他认证
                break;
            case R.id.linear_real_promiss_real://担保认证
                toActivity(Constant.ACTVIITY_ROUTE+"/real/assure_authentication/assureauthentication_activity",0);
                break;
            case R.id.linear_real_promiss://担保
                toActivity(Constant.ACTVIITY_ROUTE+"/real/assure/assure_activity",0);
                break;
        }
    }



    private void toActivity(String path,int requestCode){

        ARouter.getInstance().build(path)
                .navigation(this,requestCode);
    }
}
