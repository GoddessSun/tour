package com.sun.tour.search.more;

/**
 * Created by hanyg on 2018/1/17.
 */

public class SearchMorePresenter implements SearchMoreContract.Presenter {
    private SearchMoreContract.View mView;

    @Override
    public void bindView(SearchMoreContract.View view) {

        mView = view;
        view.bindPresenter(this);
    }
}
