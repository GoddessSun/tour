package com.sun.tour.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.MobileCheckUtil;
import com.sun.tour.view.RxToast;

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
        
    }

    @OnClick(R.id.text_register)//注册
    public void onRefisterClick(){

    }

    @OnClick(R.id.text_forget_password)//忘记密码
    public void onForgetPasswordClick(){

    }
}
