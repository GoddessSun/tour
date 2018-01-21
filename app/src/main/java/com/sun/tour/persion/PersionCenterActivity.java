package com.sun.tour.persion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.persion.adapter.PersionCenterAdapter;

import butterknife.BindView;

@Route(path = "/tour/persion/persion_center_activity")
public class PersionCenterActivity extends BaseActivity {

    @BindView(R.id.recyclerView_persion_center)
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persion_center);
        setTopTitle("个人信息");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        PersionCenterAdapter persionCenterAdapter = new PersionCenterAdapter();
        mRecyclerView.setAdapter(persionCenterAdapter);
    }
}
