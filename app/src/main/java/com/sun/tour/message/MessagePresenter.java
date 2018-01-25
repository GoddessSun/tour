package com.sun.tour.message;

/**
 * Created by hanyg on 2018/1/19.
 */

public class MessagePresenter implements MessageContract.Presenter {
    private MessageContract.View mView;

    @Override
    public void bindView(MessageContract.View view) {

        mView = view;
        view.bindPresenter(this);
    }
}
