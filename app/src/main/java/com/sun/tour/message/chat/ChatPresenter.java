package com.sun.tour.message.chat;

/**
 * Created by hanyg on 2018/1/19.
 */

public class ChatPresenter implements ChatContract.Presenter {
    private ChatContract.View mView;

    @Override
    public void bindView(ChatContract.View view) {

        mView = view;
        view.bindPresenter(this);
    }
}
