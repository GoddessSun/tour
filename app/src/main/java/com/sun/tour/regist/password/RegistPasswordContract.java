package com.sun.tour.regist.password;

import com.sun.tour.base.BasePresenter;
import com.sun.tour.base.BaseView;

/**
 * Created by hanyg on 2018/1/15.
 */

public class RegistPasswordContract {

    public interface View extends BaseView<Presenter>{

    }

    public interface Presenter extends BasePresenter<View>{

        void regist(String mobile, String password,String againPassword, String code, String nickname, int type);
    }
}
