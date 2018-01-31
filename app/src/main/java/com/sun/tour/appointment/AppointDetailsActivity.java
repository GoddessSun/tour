package com.sun.tour.appointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;

import butterknife.OnClick;

@Route(path = "/tour/appoint/appoint_details_activity")
public class AppointDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint_details);
    }

    @OnClick(R.id.linear_appoint_detail_name)
    public void onAppointDetailNameClick(){
        ARouter.getInstance().build("/tour/appointment/appoint_photo_activity").navigation();
    }
}
