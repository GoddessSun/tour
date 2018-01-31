package com.sun.tour.schedule;

import com.sun.tour.base.BasePresenter;
import com.sun.tour.base.BaseView;

/**
 * Created by hanyg on 2018/1/30.
 */

public class ScheduleContract {

    public interface View extends BaseView<Presenter> {

        void setScheduleResult(ScheduleModel model);
    }

    public interface Presenter extends BasePresenter<View>{

        void findData(long date);
    }
}
