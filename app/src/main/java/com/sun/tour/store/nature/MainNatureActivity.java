package com.sun.tour.store.nature;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 *
 * 主属性
 *
 */
@Route(path = Constant.ACTVIITY_ROUTE+"/store/nature/mainnature_activity")
public class MainNatureActivity extends BaseActivity {

    @BindView(R.id.store_edit_nature_type_tv)
    TextView tvType;
    @BindView(R.id.store_edit_nature_apply_person_tv)
    TextView tvApplyPerson;
    @BindView(R.id.store_edit_nature_handler_type_tv)
    TextView tvHandlerType;
    @BindView(R.id.store_edit_nature_location_tv)
    TextView tvLocation;
    @BindView(R.id.store_edit_nature_supply_tv)
    TextView tvSupply;
    @BindView(R.id.store_edit_nature_supply_max_tv)
    TextView tvSupplyMax;
    @BindView(R.id.store_edit_nature_form_tv)
    TextView tvForm;
    @BindView(R.id.store_edit_nature_way_tv)
    TextView tvWay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nature);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {

    }

    @OnClick({R.id.store_edit_nature_back_iv, R.id.store_edit_nature_save_tv, R.id.store_edit_nature_type_tv, R.id.store_edit_nature_apply_person_tv, R.id.store_edit_nature_handler_type_tv, R.id.store_edit_nature_location_tv, R.id.store_edit_nature_supply_tv, R.id.store_edit_nature_supply_max_tv, R.id.store_edit_nature_form_tv, R.id.store_edit_nature_way_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_nature_back_iv:
                break;
            case R.id.store_edit_nature_save_tv:
                break;
            case R.id.store_edit_nature_type_tv:
                break;
            case R.id.store_edit_nature_apply_person_tv:
                break;
            case R.id.store_edit_nature_handler_type_tv:
                break;
            case R.id.store_edit_nature_location_tv:
                break;
            case R.id.store_edit_nature_supply_tv:
                break;
            case R.id.store_edit_nature_supply_max_tv:
                break;
            case R.id.store_edit_nature_form_tv:
                break;
            case R.id.store_edit_nature_way_tv:
                break;
        }
    }
}
