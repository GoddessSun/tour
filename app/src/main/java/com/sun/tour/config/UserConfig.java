package com.sun.tour.config;


import com.sun.tour.utils.SharedPrefUtil;

/**
 * Created by kunpeng on 2016/12/14.
 */

public class UserConfig {
    //lkp test 001
    //local test 002
    //local test 003
    /*账号相关*/
    public static final String SP_IS_LOGIN = "IS_LOGIN";

    public static boolean isLogin() {
        return SharedPrefUtil.getBoolean(SP_IS_LOGIN, false);
    }

    public static void setLogin(boolean loginStatus) {
        synchronized (UserConfig.class) {
            SharedPrefUtil.putBoolean(SP_IS_LOGIN, loginStatus);
        }
    }
}
