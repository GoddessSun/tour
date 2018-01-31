package com.sun.tour.store.classify;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.store.dialog.SortDialogUtil;
import com.sun.tour.utils.Constant;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE+"/store/classify/species_activity")
public class SpeciesActivity extends BaseActivity {

    @BindView(R.id.store_edit_species_save_tv)
    TextView tvSave;
    @BindView(R.id.store_edit_species_brand_tv)
    TextView tvBrand;
    @BindView(R.id.store_edit_brand_species_tv)
    TextView tvSpecies;
    @BindView(R.id.store_edit_species_year_tv)
    TextView tvYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species);
        init();
    }

    private void init() {

    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @OnClick({R.id.store_edit_species_back_iv, R.id.store_edit_species_save_tv, R.id.store_edit_species_brand_tv, R.id.store_edit_brand_species_tv, R.id.store_edit_species_year_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_species_back_iv:
                finish();
                break;
            case R.id.store_edit_species_save_tv:
                break;
            case R.id.store_edit_species_brand_tv:
                SortDialogUtil.showBrandDialog(this);
                break;
            case R.id.store_edit_brand_species_tv:
                break;
            case R.id.store_edit_species_year_tv:
                break;
        }
    }
}
