package com.sun.tour.store.image;

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

@Route(path = Constant.ACTVIITY_ROUTE + "/store/image/image_activity")
public class ImageActivity extends BaseActivity {

    @BindView(R.id.store_edit_image_rv)
    RecyclerView rv;
    private List<String> data = new ArrayList<>();
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {

        rv.setLayoutManager(new GridLayoutManager(this,4));
        mAdapter = new ImageAdapter(this,data);
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 1; i++) {
            data.add("测试");
        }
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.store_edit_image_back_iv, R.id.store_edit_image_save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_image_back_iv:
                finish();
                break;
            case R.id.store_edit_image_save_tv:
                break;
        }
    }
}
