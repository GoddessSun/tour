package com.sun.tour.home.near;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;
import com.sun.tour.view.SortView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE + "/home/near/near_activity")
public class NearActivity extends BaseActivity {

    @BindView(R.id.home_near_v)
    SortView vNear;
    @BindView(R.id.home_near_price_v)
    SortView vPrice;
    @BindView(R.id.home_near_evaluate_v)
    SortView vEavluate;
    @BindView(R.id.home_near_use_v)
    SortView vUse;
    @BindView(R.id.home_near_more_v)
    SortView vMore;
    @BindView(R.id.near_hotal_rv)
    RecyclerView rv;

    private List<String> data = new ArrayList<>();
    private NearAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near);
        init();
    }

    private void init() {
        setTopTitle("附近推荐");
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new NearAdapter(this,data);
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 10; i++) {
            data.add("测试");
        }
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.home_near_v, R.id.home_near_price_v, R.id.home_near_evaluate_v, R.id.home_near_use_v, R.id.home_near_more_v})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_near_v:
                setNear();
                break;
            case R.id.home_near_price_v:
                if (vPrice.getSort() == SortView.DEFAULT){
                    vPrice.setSort(SortView.UP);
                }else if (vPrice.getSort() == SortView.UP){
                    vPrice.setSort(SortView.DOWN);
                }else if (vPrice.getSort() == SortView.DOWN){
                    vPrice.setSort(SortView.DEFAULT);
                }
                setPrice();
                break;
            case R.id.home_near_evaluate_v:
                setEvaluate();
                break;
            case R.id.home_near_use_v:
                setUse();
                break;
            case R.id.home_near_more_v:
                setMore();
                break;
        }
    }

    private void setMore() {
        vNear.setChecked(false);
        vPrice.setChecked(false);
        vPrice.setSort(SortView.DEFAULT);
        vEavluate.setChecked(false);
        vUse.setChecked(false);
        vMore.setChecked(true);
    }

    private void setUse() {
        vNear.setChecked(false);
        vPrice.setChecked(false);
        vPrice.setSort(SortView.DEFAULT);
        vEavluate.setChecked(false);
        vUse.setChecked(true);
        vMore.setChecked(false);
    }

    private void setEvaluate() {
        vNear.setChecked(false);
        vPrice.setChecked(false);
        vPrice.setSort(SortView.DEFAULT);
        vEavluate.setChecked(true);
        vUse.setChecked(false);
        vMore.setChecked(false);
    }

    private void setPrice() {
        vNear.setChecked(false);
        vPrice.setChecked(true);
        vEavluate.setChecked(false);
        vUse.setChecked(false);
        vMore.setChecked(false);

    }

    private void setNear() {
        vNear.setChecked(true);
        vPrice.setChecked(false);
        vPrice.setSort(SortView.DEFAULT);
        vEavluate.setChecked(false);
        vUse.setChecked(false);
        vMore.setChecked(false);
    }
}
