package com.sun.tour.appointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.appointment.adapter.AddPhotoAdapter;
import com.sun.tour.base.BaseActivity;

import butterknife.BindView;

@Route(path = "/tour/appointment/appoint_photo_activity")
public class AppointPhotosActivity extends BaseActivity {

    @BindView(R.id.recyclerView_appoint_photo_first)
    RecyclerView mFirstRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint_photos);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        mFirstRecyclerView.setLayoutManager(gridLayoutManager);
        mFirstRecyclerView.setAdapter(new AddPhotoAdapter(null));


    }
}
