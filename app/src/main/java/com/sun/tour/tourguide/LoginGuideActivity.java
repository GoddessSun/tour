package com.sun.tour.tourguide;

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
 * 登录指导
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/login/guide/loginguide_activity")
public class LoginGuideActivity extends BaseActivity {

    @BindView(R.id.login_guide_rv)
    RecyclerView rv;
    private List<GuideModel> data = new ArrayList<>();
    private GuideAdapter mAdapter;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_guide);
        init();
    }

    private void init() {
        getBundleData();
        if (type == Constant.GUIDE.LOGIN_GUIDE){
            setTopTitle("登录指导");
        }else if (type == Constant.GUIDE.USE_GUIDE){
            setTopTitle("使用指导");
        }
        mAdapter = new GuideAdapter(this,data);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                GuideModel model = new GuideModel();
                if (j == 0){
                    model.setShow(true);
                }
                model.setTitle("流程"+i);
                model.setContent("指导"+j);
                data.add(model);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    private void getBundleData() {
        Bundle bundle = getIntent().getExtras();
        type = bundle.getInt("type",0);
    }
}
