package com.sun.tour.search;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 基本搜索
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/search/search_activity")
public class SearchActivity extends BaseActivity implements SearchContract.View {

    @BindView(R.id.search_title_search_et)
    EditText etSearch;
    @BindView(R.id.search_title_layout)
    LinearLayout searchLayout;
    @BindView(R.id.search_history_clear_tv)
    TextView tvClear;
    @BindView(R.id.search_history_rv)
    RecyclerView rv;
    private SearchContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        SearchPresenter searchPresenter = new SearchPresenter();
        searchPresenter.bindView(this);
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @Override
    public void bindPresenter(SearchContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @OnClick({R.id.search_cancel_iv, R.id.search_title_layout, R.id.search_history_clear_tv, R.id.search_more_bottom_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_cancel_iv:
                break;
            case R.id.search_title_layout:
                break;
            case R.id.search_history_clear_tv:
                break;
            case R.id.search_more_bottom_btn:
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/search/more/searchmore_activity")
                        .navigation();
                break;
        }
    }
}
