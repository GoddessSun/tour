package com.sun.tour.message.chat;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

/**
 *
 * 聊天界面
 *
 *
 */
@Route(path = Constant.ACTVIITY_ROUTE+"/message/chat/chat_activity")
public class ChatActivity extends BaseActivity implements ChatContract.View{

    private ChatContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {
        ChatPresenter chatPresenter = new ChatPresenter();
        chatPresenter.bindView(this);
    }

    @Override
    public void bindPresenter(ChatContract.Presenter presenter) {

        this.presenter = presenter;
    }
}
