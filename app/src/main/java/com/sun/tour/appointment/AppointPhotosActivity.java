package com.sun.tour.appointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
@Route(path = "/tour/appointment/appoint_photo_activity")
public class AppointPhotosActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint_photos);
    }
}
