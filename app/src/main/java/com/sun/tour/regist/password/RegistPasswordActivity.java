package com.sun.tour.regist.password;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE + "/regist/password/registpassword_activitry")
public class RegistPasswordActivity extends BaseActivity implements RegistPasswordContract.View {

    @Autowired
    Bundle bundle;
    @BindView(R.id.regist_password_et)
    EditText etPassword;
    @BindView(R.id.regist_password_again_et)
    EditText etAgainPassword;

    private String mobile;
    private String code;
    private String nickname;
    private int type;
    private RegistPasswordContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_password);
        init();
    }

    private void init() {
        //初始化头部
        setLeftVisibility(View.VISIBLE);
        setTopTitle(getResources().getString(R.string.regist_set_password_title));

        getBundleData();

        RegistPasswordPresenter registPasswordPresenter = new RegistPasswordPresenter(this);
        registPasswordPresenter.bindView(this);


    }

    /**
     * 获取数据
     */
    private void getBundleData() {

        if (bundle == null) {
            return;
        }
        mobile = bundle.getString("mobile");
        code = bundle.getString("code");
        nickname = bundle.getString("nickname");
    }

    @Override
    public void bindPresenter(RegistPasswordContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @OnClick(R.id.regist_finish_btn)
    public void onClick() {

        if (presenter != null) {
            presenter.regist(mobile,etPassword.getText().toString(),etAgainPassword.getText().toString(),code,nickname,type);
        }
    }
}
