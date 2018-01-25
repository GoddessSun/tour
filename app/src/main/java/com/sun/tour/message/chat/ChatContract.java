package com.sun.tour.message.chat;

import com.sun.tour.base.BasePresenter;
import com.sun.tour.base.BaseView;

/**
 * Created by hanyg on 2018/1/19.
 */

public class ChatContract {

    public interface View extends BaseView<Presenter>{

    }

    public interface Presenter extends BasePresenter<View>{

    }
}
