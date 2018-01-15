package com.sun.tour.db;

import android.content.Context;


/**
 * Created by hanyg on 2018/1/10.
 */

public class GreenDaoUtils {

    public static final String DB_NAME = "test"; //数据库名称
    private static GreenDaoUtils greenDaoUtils;
    private Context context;

    private GreenDaoUtils(Context context){

        this.context = context;
    }

    public static GreenDaoUtils getInstance(Context context){

        if (greenDaoUtils == null) {
            greenDaoUtils = new GreenDaoUtils(context);
        }
        return greenDaoUtils;
    }
}
