package com.sun.tour.regist;

/**
 * Created by hanyg on 2018/1/15.
 */

public class RegistPresenter implements RegistContract.Presenter {
    private RegistContract.View mView;

    @Override
    public void bindView(RegistContract.View view) {

        this.mView = view;
        view.bindPresenter(this);
    }
}
