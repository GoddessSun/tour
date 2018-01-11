package com.sun.tour;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionNo;
import com.yanzhenjie.permission.PermissionYes;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private String[] mPermissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA};
    public static final int REQUEST_CODE = 0x01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        if (!AndPermission.hasPermission(this,mPermissions)){
            AndPermission.with(this)
                    .requestCode(REQUEST_CODE)
                    .permission(mPermissions)
                    .callback(this)
                    .start();
        }else {
            initSkip();

        }
    }

    private void initSkip() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build("/tour/main/main_activity").navigation();
                finish();
            }
        },1000);
    }


    @PermissionYes(REQUEST_CODE)
    public void getPermissionYes(@NonNull List<String> deniedPermissions){
        initSkip();
    }

    @PermissionNo(REQUEST_CODE)
    public void getPermissionNo(@NonNull List<String> deniedPermissions){
        finish();
    }

}
