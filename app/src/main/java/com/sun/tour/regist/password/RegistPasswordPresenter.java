package com.sun.tour.regist.password;

import android.content.Context;
import android.text.TextUtils;

import com.sun.tour.network.RetrofitUtils;
import com.sun.tour.network.callback.NetWorkCallBack;
import com.sun.tour.result.Result;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hanyg on 2018/1/15.
 */

public class RegistPasswordPresenter implements RegistPasswordContract.Presenter {
    private RegistPasswordContract.View mView;
    private Context context;

    public RegistPasswordPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bindView(RegistPasswordContract.View view) {

        mView = view;
        view.bindPresenter(this);
    }

    @Override
    public void regist(String mobile, String password,String againPassword, String code, String nickname, int type) {


        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(againPassword)){
            return;
        }

        if (!TextUtils.equals(password, againPassword)) {

            return;
        }

        RetrofitUtils.getInstance().registUser(mobile,password,"0",code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetWorkCallBack<Result>() {
                    @Override
                    public void onSuccess(Result result) {

                    }

                    @Override
                    public void onFailed(String msg) {

                    }
                });

    }
}
