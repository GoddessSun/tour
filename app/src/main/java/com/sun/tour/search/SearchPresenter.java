package com.sun.tour.search;

/**
 * Created by hanyg on 2018/1/17.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View mView;

    @Override
    public void bindView(SearchContract.View view) {

        mView = view;
        view.bindPresenter(this);
    }
}
