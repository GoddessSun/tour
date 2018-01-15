package com.sun.tour.network.callback;

import com.sun.tour.result.Result;

import rx.Observer;

/**
 *
 *
 * 返回
 *
 * Created by hanyg on 2018/1/15.
 */

public abstract class NetWorkCallBack<T> implements Observer<T> {


    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onNext(T t) {

        if (t == null) {
            onFailed("返回为空");
            return;
        }
        if (!(t instanceof Result)) {
            onFailed("数据结构变化");
            return;
        }
        if (!((Result)t).isStatus()) {
            onFailed("请求失败");
            return;
        }
        onSuccess(t);
    }

    public abstract void onSuccess(T t);

    /**
     *
     * 错误原因
     *
     * @param msg
     */
    public abstract void onFailed(String msg);
}
