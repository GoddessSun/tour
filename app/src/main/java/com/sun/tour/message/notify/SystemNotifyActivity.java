package com.sun.tour.message.notify;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 系统通知
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/message/notify/systemnotify_activity")
public class SystemNotifyActivity extends BaseActivity {

    @BindView(R.id.system_notify_rv)
    RecyclerView rv;
    private List<String> data = new ArrayList<>();
    private SystemNotifyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_notify);
        init();
    }

    private void init() {
        setTopTitle("系统消息");
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new SystemNotifyAdapter(this,data);
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 2; i++) {
            data.add("测试");
        }
        mAdapter.notifyDataSetChanged();
    }
}
