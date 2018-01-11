package com.sun.tour.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by cuiwei on 2016/5/3.
 */
public class SharedPrefUtil {
    private static final String SPNAME = "Tour";
    public static final String SP_IS_FIRST_LOGIN = "is_first";
    private static Context mContext = null;
    private static SharedPreferences sharedPreferences = null;
    private static Editor editor = null;// 获取编辑器

    /**
     * 初始化
     */
    public static void init(Context context) {
        try {
            if (mContext == null) {
                mContext = context;
                sharedPreferences = mContext.getSharedPreferences(SPNAME,
                        Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 保存String
     */
    public static boolean putString(String key, String value) {
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * 保存boolean
     */
    public static boolean putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * 保存int
     */
    public static boolean putInt(String key, int value) {
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * 保存 long
     */
    public static boolean putLong(String key, long value) {
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * 读取String
     */
    public static String getString(String key) {
        if (null == sharedPreferences) {
            sharedPreferences = mContext.getSharedPreferences(SPNAME,
                    Context.MODE_PRIVATE);
        }
        String value = sharedPreferences.getString(key, "");
        return value;
    }

    /**
     * 读取boolean
     */
    public static boolean getBoolean(String key) {
        if (null == sharedPreferences) {
            sharedPreferences = mContext.getSharedPreferences(SPNAME,
                    Context.MODE_PRIVATE);
        }
        boolean value = sharedPreferences.getBoolean(key, false);
        return value;
    }

    /**
     * 读取boolean
     */
    public static boolean getBoolean(String key, boolean def) {
        if (null == sharedPreferences) {
            sharedPreferences = mContext.getSharedPreferences(SPNAME,
                    Context.MODE_PRIVATE);
        }
        boolean value = sharedPreferences.getBoolean(key, def);
        return value;
    }

    /**
     * 读取int
     */
    public static int getInt(String key) {
        if (null == sharedPreferences) {
            sharedPreferences = mContext.getSharedPreferences(SPNAME,
                    Context.MODE_PRIVATE);
        }
        int value = sharedPreferences.getInt(key, 0);
        return value;
    }

    /**
     * 读取int
     */
    public static int getInt(String key, int defaultValue) {
        if (null == sharedPreferences) {
            sharedPreferences = mContext.getSharedPreferences(SPNAME,
                    Context.MODE_PRIVATE);
        }
        int value = sharedPreferences.getInt(key, defaultValue);
        return value;
    }

    /**
     * 读取 long
     */
    public static long getLong(String key, long defaultValue) {
        if (null == sharedPreferences) {
            sharedPreferences = mContext.getSharedPreferences(SPNAME,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.getLong(key, defaultValue);
    }

    /**
     * 清空所有数据
     */

    public static void clearAll() {
        if (null != editor) {
            editor.clear();
            editor.commit();
        }
    }
}
