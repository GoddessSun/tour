package com.sun.tour.regist;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE + "/regist/regist_activity")
public class RegistActivity extends BaseActivity implements RegistContract.View {

    @BindView(R.id.regist_mobile_et)
    EditText etMobile;
    @BindView(R.id.regist_code_et)
    EditText etCode;
    @BindView(R.id.regist_get_code_tv)
    TextView tvCode;
    @BindView(R.id.regist_nickname_et)
    EditText etNickname;
    @BindView(R.id.regist_agreenment_cb)
    CheckBox registAgreenmentCb;
    private RegistContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();
    }

    private void init() {
        //初始化头部
        setTopTitle(getResources().getString(R.string.regist));
        //初始化mvp
        RegistPresenter registPresenter = new RegistPresenter(this);
        registPresenter.bindView(this);

    }

    @Override
    public void bindPresenter(RegistContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @OnClick({R.id.regist_get_code_tv, R.id.regist_agreenment_tv, R.id.regist_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regist_get_code_tv:
                if (!TextUtils.equals(getResources().getString(R.string.get_code),tvCode.getText().toString())){
                    return;
                }
                if (presenter != null) {
                    presenter.sendMobile(etMobile.getText().toString());
                }
                break;
            case R.id.regist_agreenment_tv:
                break;
            case R.id.regist_btn:
                if (presenter != null) {
                    presenter.judgeTextEmpty(registAgreenmentCb.isChecked(),etMobile.getText().toString(),etCode.getText().toString(),etNickname.getText().toString());
                }
                break;
        }
    }

    @Override
    public void setCodeResult(String s) {

        tvCode.setText(s);
    }

    @Override
    public void toActivity(String mobile, String code, String nickname) {

        Bundle bundle = new Bundle();
        bundle.putString("mobile",mobile);
        bundle.putString("code",code);
        bundle.putString("nickname",nickname);
        ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/regist/password/registpassword_activitry")
                .with(bundle)
                .navigation();

    }
}
