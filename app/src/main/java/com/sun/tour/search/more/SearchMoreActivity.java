package com.sun.tour.search.more;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

@Route(path = Constant.ACTVIITY_ROUTE+"/search/more/searchmore_activity")
public class SearchMoreActivity extends BaseActivity implements SearchMoreContract.View {

    private SearchMoreContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_more);

        init();
    }

    private void init() {

    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @Override
    public void bindPresenter(SearchMoreContract.Presenter presenter) {

        this.presenter = presenter;
    }
}
