package com.sun.tour.regist;

import com.sun.tour.base.BasePresenter;
import com.sun.tour.base.BaseView;

/**
 * Created by hanyg on 2018/1/15.
 */

public class RegistContract {

    public interface View extends BaseView<Presenter>{

        void setCodeResult(String s);

        void toActivity(String mobile, String code, String nickname);
    }

    public interface Presenter extends BasePresenter<View>{

        void sendMobile(String mobile);

        void judgeTextEmpty(boolean checked, String mobile, String code, String nickname);
    }
}
