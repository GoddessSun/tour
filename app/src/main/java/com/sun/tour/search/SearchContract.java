package com.sun.tour.search;

import com.sun.tour.base.BasePresenter;
import com.sun.tour.base.BaseView;

/**
 * Created by hanyg on 2018/1/17.
 */

public class SearchContract {

    public interface View extends BaseView<Presenter>{

    }

    public interface Presenter extends BasePresenter<View>{

    }
}
