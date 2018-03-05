package com.sun.tour.regist;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;

import com.sun.tour.R;
import com.sun.tour.network.RetrofitUtils;
import com.sun.tour.network.callback.NetWorkCallBack;
import com.sun.tour.result.Result;
import com.sun.tour.view.RxToast;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hanyg on 2018/1/15.
 */

public class RegistPresenter implements RegistContract.Presenter {
    private RegistContract.View mView;
    private Context context;
    private CountDownTimer mTimer;

    public RegistPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bindView(RegistContract.View view) {

        this.mView = view;
        view.bindPresenter(this);
    }

    @Override
    public void sendMobile(String mobile) {

        if (TextUtils.isEmpty(mobile)) {

            RxToast.showToast(R.string.mobile_hint);
            return;
        }
        countDownTimer();
//        RetrofitUtils.getInstance().sendCode(mobile)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new NetWorkCallBack<Result>() {
//                    @Override
//                    public void onSuccess(Result result) {
//
//                        countDownTimer();
//
//                    }
//
//                    @Override
//                    public void onFailed(String msg) {
//                        RxToast.showToast(msg);
//                    }
//                });


    }

    /**
     *
     *
     * 跳转Activity之前判空
     * @param checked
     * @param mobile
     * @param code
     * @param nickname
     */
    @Override
    public void judgeTextEmpty(boolean checked, String mobile, String code, String nickname) {

        if (TextUtils.isEmpty(mobile)) {
            RxToast.showToast(R.string.mobile_hint);
            return;
        }

        if (TextUtils.isEmpty(code)) {
            RxToast.showToast(R.string.code_hint);
            return;
        }

        if (TextUtils.isEmpty(nickname)) {
            RxToast.showToast(R.string.nickname_hint);
            return;
        }

        if (!checked){
            RxToast.showToast(R.string.agreenment);
            return;
        }
        if (mView != null){

            mView.toActivity(mobile,code,nickname);
        }

    }

    @Override
    public void cancleTimer() {
        if (mTimer!=null){
            mTimer.cancel();
            mTimer = null;
        }
    }

    /**
     *
     *
     * 60s定时器
     *
     */
    private void countDownTimer(){

        mTimer = new CountDownTimer(60*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (mView != null){
                    mView.setCodeResult((millisUntilFinished/1000)+"s");
                }
            }

            @Override
            public void onFinish() {
                if (mView != null){
                    mView.setCodeResult(context.getResources().getString(R.string.get_code));
                }
                cancel();
            }
        };
        mTimer.start();
    }



}
