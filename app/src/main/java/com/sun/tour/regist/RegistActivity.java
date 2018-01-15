package com.sun.tour.regist;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

@Route(path = Constant.ACTVIITY_ROUTE+"/regist/regist_activity")
public class RegistActivity extends BaseActivity implements RegistContract.View{

    private RegistContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();
    }

    private void init() {
        RegistPresenter registPresenter = new RegistPresenter();
        registPresenter.bindView(this);
    }

    @Override
    public void bindPresenter(RegistContract.Presenter presenter) {

        this.presenter = presenter;
    }
}
