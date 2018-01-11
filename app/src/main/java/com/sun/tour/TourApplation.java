package com.sun.tour;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Date: 2018/1/11
 * Time: 16:17
 * author: sunmingmao
 */

public class TourApplation extends Application {

    private static TourApplation mApplication;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
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
}
