package com.sun.tour;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.tour.result.User;
import com.sun.tour.utils.SharedPrefUtil;

/**
 * Date: 2018/1/11
 * Time: 16:17
 * author: sunmingmao
 */

public class TourApplation extends Application {

    private static TourApplation mApplication;
    private String mUserToken; //当前用户token
    private User mUser;//当前用户

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        SharedPrefUtil.init(mApplication);
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();
        ARouter.init(mApplication); // 尽可能早，推荐在Application中初始化

    }

    public static Context getAppContext() {
        return mApplication;
    }

    public static TourApplation getInstance() {
        return mApplication;
    }

    public User getActiveUser() {
        if (mUser == null) {
            Gson gson = new Gson();
            User user = null;
            try {
                String userString = SharedPrefUtil.getString(SharedPrefUtil.SP_ACTIVE_ACCOUNT);
                user = gson.fromJson(userString, User.class);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            if (user != null) {
                mUser = user;
            }
        }
        return mUser;
    }

    public synchronized void setActiveUser(User user) {
        mUser = user;
        if (user == null) {
            SharedPrefUtil.putString(SharedPrefUtil.SP_ACTIVE_ACCOUNT, "");
        } else {
            Gson gson = new Gson();
            String userString = gson.toJson(user);
            SharedPrefUtil.putString(SharedPrefUtil.SP_ACTIVE_ACCOUNT, userString);
//            setActiveUserToken(user.token);
        }
    }

    public String getActiveUserToken() {
        if (TextUtils.isEmpty(mUserToken)) {
            mUserToken = SharedPrefUtil.getString(SharedPrefUtil.SP_ACTIVE_TOKEN);
        }
        return mUserToken;
    }

    public synchronized void setActiveUserToken(String userToken) {
        if (!TextUtils.isEmpty(userToken)) {
            mUserToken = userToken;
            SharedPrefUtil.putString(SharedPrefUtil.SP_ACTIVE_TOKEN, userToken);
        }
    }
}
