package com.sun.tour.persion.authentication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE + "/persion/authentication/authentication_activity")
public class AuthenticationActivity extends BaseActivity {

    @BindView(R.id.authentication_person_identity_tv)
    TextView tvPersonIdentity;
    @BindView(R.id.authentication_phone_tv)
    TextView tvPhone;
    @BindView(R.id.authentication_other_identity_tv)
    TextView tvOther;
    @BindView(R.id.authentication_assure_authentication_tv)
    TextView tvAssureAuthentication;
    @BindView(R.id.authentication_assure_tv)
    TextView tvAssure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        init();
    }

    private void init() {
        setTopTitle("认证");
    }

    @OnClick({R.id.authentication_person_identity_tv, R.id.authentication_phone_tv, R.id.authentication_other_identity_tv, R.id.authentication_assure_authentication_tv, R.id.authentication_assure_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.authentication_person_identity_tv:
                toActivity(Constant.ACTVIITY_ROUTE + "/persion/authentication/identity_person_activity",0);
                break;
            case R.id.authentication_phone_tv:
                toActivity(Constant.ACTVIITY_ROUTE+"persion/authentication/phone/phoneauthentication_activity",0);
                break;
            case R.id.authentication_other_identity_tv:
                break;
            case R.id.authentication_assure_authentication_tv:
                toActivity(Constant.ACTVIITY_ROUTE+"/persion/authentication/assure_authentication/assureauthentication_activity",0);
                break;
            case R.id.authentication_assure_tv:
                toActivity(Constant.ACTVIITY_ROUTE+"/persion/authentication/assure/assure_activity",0);
                break;
        }
    }

    private void toActivity(String path,int requestCode){

        ARouter.getInstance().build(path)
                .navigation(this,requestCode);
    }
}
