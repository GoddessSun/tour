package com.sun.tour.network;

import com.sun.tour.result.Result;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 *
 * 请求接口
 *
 * Created by hanyg on 2018/1/9.
 */

public interface NetWorkApi {

    //发送验证码
    @FormUrlEncoded
    @POST("common/send-code")
    Observable<Result> sendCodeApi(@Field("phone") String phone);

    //注册
    @FormUrlEncoded
    @POST("/user/register")
    Observable<Result> registUser(@Field("mobile") String mobile,
                                  @Field("password") String password,
                                  @Field("type") String type,
                                  @Field("code") String code);
}
