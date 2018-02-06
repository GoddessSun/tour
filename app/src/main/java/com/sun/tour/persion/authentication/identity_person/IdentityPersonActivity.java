package com.sun.tour.persion.authentication.identity_person;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;
import com.sun.tour.view.FullRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = Constant.ACTVIITY_ROUTE + "/persion/authentication/identity_person_activity")
public class IdentityPersonActivity extends BaseActivity {

    @BindView(R.id.identity_person_rv)
    FullRecyclerView rv;
    private List<String> data = new ArrayList<>();
    private IdentityPersonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_person);
        init();
    }

    private void init() {

        setTopTitle("个人身份");
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new IdentityPersonAdapter(this,data);
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 3; i++) {
            data.add("测试");
        }
        mAdapter.notifyDataSetChanged();
    }
}
