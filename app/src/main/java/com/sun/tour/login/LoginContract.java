package com.sun.tour.login;

import com.sun.tour.base.BasePresenter;
import com.sun.tour.base.BaseView;

/**
 * Created by lenovo on 2018/1/16.
 */

public class LoginContract {
    public interface View extends BaseView<Presenter> {
        void onLoginSuccess();
    }

    public interface Presenter extends BasePresenter<View> {

        void onLogin(String mobile, String password);
    }
}
