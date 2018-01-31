package com.sun.tour.store.address;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;
import com.sun.tour.view.FullRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 *
 * 编辑地址
 *
 */
@Route(path = Constant.ACTVIITY_ROUTE+"/store/address/address_activity")
public class AddressActivity extends BaseActivity {

    @BindView(R.id.store_edit_address_rv)
    FullRecyclerView rv;
    @BindView(R.id.store_edit_address_bottom_add_tv)
    TextView tvAdd;
    private List<String> data = new ArrayList<>();
    private AddressAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        init();
    }

    private void init() {

        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new AddressAdapter(this,data);
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 3; i++) {
            data.add("测试");
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @OnClick({R.id.store_edit_address_back_iv, R.id.store_edit_address_save_tv, R.id.store_edit_address_bottom_add_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_address_back_iv:
                finish();
                break;
            case R.id.store_edit_address_save_tv:
                break;
            case R.id.store_edit_address_bottom_add_tv:
                break;
        }
    }
}
