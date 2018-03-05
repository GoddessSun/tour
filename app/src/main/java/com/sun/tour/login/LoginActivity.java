package com.sun.tour.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.TourApplation;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.config.UserConfig;
import com.sun.tour.event.LoginEvent;
import com.sun.tour.result.User;
import com.sun.tour.utils.Constant;
import com.sun.tour.utils.MobileCheckUtil;
import com.sun.tour.utils.SharedPrefUtil;
import com.sun.tour.view.RxToast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/tour/login/login_activity")
public class LoginActivity extends BaseActivity {

    @BindView(R.id.edit_phone)
    EditText mPhoneEditView;
    @BindView(R.id.edit_password)
    EditText mPasswordEditText;
    @BindView(R.id.checkbox_remember_password)
    CheckBox mPasswordCheckBox;
    @BindView(R.id.image_is_can_see)
    ImageView mIsCanSeeImageView;
    private boolean  isCanSee = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTopTitle("登录");
    }

    @OnClick(R.id.image_is_can_see)//密码是否可见
    public void IsCanSeeClick(){
        if (mPasswordEditText.getText().toString().length()>0){
            if (!isCanSee){//密码可见
                mIsCanSeeImageView.setImageResource(R.drawable.ic_visiable_password);
                mPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else {//密码不可见
                mIsCanSeeImageView.setImageResource(R.drawable.ic_no_visiable_password);
                mPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            isCanSee = !isCanSee;
            mPasswordEditText.setSelection(mPasswordEditText.getText().toString().length());
        }else {
            RxToast.info(this,"请输入密码").show();
        }
    }

    @OnClick(R.id.btn_login)//登录
    public void onLoginClick(){
        if (!MobileCheckUtil.isRealMobile(mPhoneEditView.getText().toString().trim())){
            RxToast.info(this,"请输入正确的手机号").show();
            return;
        }
        if (TextUtils.isEmpty(mPasswordEditText.getText().toString().trim())){
            RxToast.info(this,"请输入密码").show();
            return;
        }

        if (mPasswordCheckBox.isChecked()){
            SharedPrefUtil.putString(SharedPrefUtil.USER_PASSWORD,mPasswordEditText.getText().toString().trim());
        }

        //假数据  模拟跳转
        User user = new User();
        user.mobile = mPhoneEditView.getText().toString().trim();
        user.password = mPasswordEditText.getText().toString().trim();
        user.headerImgUrl = "http://img4.imgtn.bdimg.com/it/u=3537253734,3552658244&fm=27&gp=0.jpg";
        user.nick = "用户"+user.mobile.substring(user.mobile.length()-4,user.mobile.length());
        if (TextUtils.isEmpty(user.userSummary)){
            user.userSummary = "快来设置您的签名吧^_~";
        }
        TourApplation.getInstance().setActiveUser(user);
        SharedPrefUtil.putString(SharedPrefUtil.USER_NAME,mPhoneEditView.getText().toString().trim());
        UserConfig.setLogin(true);
        LoginActivity.this.finish();
        ARouter.getInstance().build("/tour/main/main_activity").navigation(this);


    }

    @OnClick(R.id.text_register)//注册
    public void onRefisterClick(){
        ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/regist/regist_activity").navigation(this);
    }

    @OnClick(R.id.text_forget_password)//忘记密码
    public void onForgetPasswordClick(){
        ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/login/forgetpassword/passwordforget_activity").navigation(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onLoginEvent(LoginEvent loginEvent){
        if (loginEvent.isLogin){
            finish();
        }
    }
}
