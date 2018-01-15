package com.sun.tour.network;

import com.sun.tour.result.Result;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 *
 * 请求网络总口
 *
 * Created by hanyg on 2018/1/9.
 */

public class RetrofitUtils {

    public static final String BASE_URL = "http://ddlog.cn:85/";
    private static RetrofitUtils utils;
    private final OkHttpClient okHttpClient;

    private RetrofitUtils() {

        okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true) //失败有设置可以重连
                .connectTimeout(30, TimeUnit.SECONDS) //网络超时30s
                .build();

    }

    public static RetrofitUtils getInstance(){

        if (utils == null) {
            utils = new RetrofitUtils();
        }
        return utils;
    }

    private NetWorkApi getNetWorkApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(NetWorkApi.class);
    }

    /**
     *
     * 发送验证码
     *
     * @param mobile
     * @return
     */
    public Observable<Result> sendCode(String mobile){

        return getNetWorkApi().sendCodeApi(mobile);
    }

    /**
     *
     * 注册
     *
     * @param mobile
     * @param password
     * @param type
     * @param code
     * @return
     */
    public Observable<Result> registUser(String mobile, String password, String type, String code){

        return getNetWorkApi().registUser(mobile,password,type,code);
    }
}
