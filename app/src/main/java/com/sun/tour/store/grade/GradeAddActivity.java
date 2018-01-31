package com.sun.tour.store.grade;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 *
 * 加分项
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/store/grade/gradeadd_activity")
public class GradeAddActivity extends BaseActivity {

    @BindView(R.id.store_edit_grade_add_rv)
    RecyclerView rv;
    private List<String> data = new ArrayList<>();
    private GradeAddAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_add);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {

        mAdapter = new GradeAddAdapter(this,data);
        rv.setLayoutManager(new GridLayoutManager(this,4));
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 12; i++) {
            data.add("测试"+i);
        }
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.store_edit_grade_add_back_iv, R.id.store_edit_grade_add_save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_grade_add_back_iv:
                finish();
                break;
            case R.id.store_edit_grade_add_save_tv:
                break;
        }
    }
}
