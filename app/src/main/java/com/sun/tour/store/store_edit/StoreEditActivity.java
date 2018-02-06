package com.sun.tour.store.store_edit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE + "/store/store_edit/storeedit_acitivity")
public class StoreEditActivity extends BaseActivity {

    @BindView(R.id.store_edit_evaluate_tv)
    TextView tvEvaluate;
    @BindView(R.id.store_edit_classify_iv)
    ImageView ivClassify;
    @BindView(R.id.store_edit_nature_iv)
    ImageView ivNature;
    @BindView(R.id.store_edit_add_grade_iv)
    ImageView ivAddGrade;
    @BindView(R.id.store_edit_address_iv)
    ImageView ivAddress;
    @BindView(R.id.store_edit_price_iv)
    ImageView tvPrice;
    @BindView(R.id.store_edit_image_iv)
    ImageView ivImage;
    @BindView(R.id.store_edit_text_iv)
    ImageView ivText;
    @BindView(R.id.store_edit_identity_iv)
    ImageView ivIdentity;
    @BindView(R.id.store_edit_matter_tv)
    TextView tvMatter;
    @BindView(R.id.store_edit_limit_tv)
    TextView tvLimit;
    @BindView(R.id.store_edit_supply_tv)
    TextView tvSupply;
    @BindView(R.id.store_edit_share_tv)
    TextView tvShare;
    @BindView(R.id.store_edit_cancel_cost_tv)
    TextView tvCost;
    @BindView(R.id.store_edit_login_btn)
    Button storeEditLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_edit);
        init();
    }

    private void init() {


    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @OnClick({R.id.store_edit_back_iv, R.id.store_edit_evaluate_tv, R.id.store_edit_classify_iv, R.id.store_edit_nature_iv, R.id.store_edit_add_grade_iv, R.id.store_edit_address_iv, R.id.store_edit_price_iv, R.id.store_edit_image_iv, R.id.store_edit_text_iv, R.id.store_edit_identity_iv, R.id.store_edit_matter_tv, R.id.store_edit_limit_tv, R.id.store_edit_supply_tv, R.id.store_edit_share_tv, R.id.store_edit_cancel_cost_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_back_iv:
                finish();
                break;
            case R.id.store_edit_evaluate_tv:
                break;
            case R.id.store_edit_classify_iv:
                toActivity(Constant.ACTVIITY_ROUTE+"/store/classify/species_activity",0);
                break;
            case R.id.store_edit_nature_iv:
                toActivity(Constant.ACTVIITY_ROUTE+"/store/nature/mainnature_activity",0);
                break;
            case R.id.store_edit_add_grade_iv:
                toActivity(Constant.ACTVIITY_ROUTE + "/store/grade/gradeadd_activity",0);
                break;
            case R.id.store_edit_address_iv:
                toActivity(Constant.ACTVIITY_ROUTE+"/store/address/address_activity",0);
                break;
            case R.id.store_edit_price_iv:
                toActivity(Constant.ACTVIITY_ROUTE+"/store/price/price_activity",0);
                break;
            case R.id.store_edit_image_iv:
                toActivity(Constant.ACTVIITY_ROUTE + "/store/image/image_activity",1);
                break;
            case R.id.store_edit_text_iv:
                toActivity(Constant.ACTVIITY_ROUTE+"/store/text/text_activity",0);
                break;
            case R.id.store_edit_identity_iv:
                toActivity(Constant.ACTVIITY_ROUTE + "/persion/authentication/authentication_activity",0);
                break;
            case R.id.store_edit_matter_tv:
                toActivity(Constant.ACTVIITY_ROUTE+"/schedule/schedule_activity",0);
                break;
            case R.id.store_edit_limit_tv:
                break;
            case R.id.store_edit_supply_tv:
                break;
            case R.id.store_edit_share_tv:
                break;
            case R.id.store_edit_cancel_cost_tv:
                break;
        }
    }

    private void toActivity(String path,int requestCode){
        ARouter.getInstance().build(path).navigation(this,requestCode);
    }
}
