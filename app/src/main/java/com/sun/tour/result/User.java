package com.sun.tour.result;

/**
 * Date: 2018/1/17
 * Time: 11:19
 * author: sunmingmao
 */

public class User extends Result {
    public String id;//用户id
    public String headerImgUrl;//头像地址 初始化注册用户为空
    public String userSummary;//个人简介
    public float createTime;//创建时间
    public float updateTime;//最后更新时间
    public String password;//
    public String mobile;//
    public String realName;//真实姓名
    public String nick;//昵称
    public String cardNo;//身份证号
    public String cardImg1;//身份证正面照片
    public String cardImg2;//身份证反面照片
    public String cardImg3;//手持身份证照片
    public int cardVerifyStatus;//身份认证状态 0=未认证 1=审核中 2=审核失败 3=已认证
    public int mobileVerifyStatus;//电话认证状态 0=未认证 1=审核中 2=审核失败 3=已认证
    public String bailId;//担保人id
    public String bailVerifyStatus;//担保审核状态  0=未认证 1=审核中 2=审核失败 3=已认证
    public int userType;//0=普通用户 1=商家
    public float cardVerifyTimeEnd;//身份证认证有效期 tlsSig为腾讯IM登录使用 sig 账号使用mobile字段
    public float tlsSigInvalidTime;//电话认证有效期
    public String tlsSig;//
    public String mobileVerifyNumber;//电话认证手机号

}
