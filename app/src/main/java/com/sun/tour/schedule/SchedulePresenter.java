package com.sun.tour.schedule;

import android.content.Context;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hanyg on 2018/1/30.
 */

public class SchedulePresenter implements ScheduleContract.Presenter {
    private Context context;
    private ScheduleContract.View mView;

    public SchedulePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bindView(ScheduleContract.View view) {

        mView = view;
        view.bindPresenter(this);
    }

    /**
     * 获取月份起始日期
     *
     */
    public ScheduleModel getMinMonthDate(long time){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);

        Log.e("date","----月初------="+day);
        ScheduleModel model = new ScheduleModel();
        model.setYear(year);
        model.setMonth(month);
        model.setDay(day);
        model.setDate(year+"-"+month+"-"+day);
        model.setWeek(getWeek(model.getDate()));
        return model;
    }

    private int getWeek(String time){

        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(format.parse(time));
            return calendar.get(Calendar.DAY_OF_WEEK)-1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
    /**
     * 获取月份最后日期
     *
     */
    public ScheduleModel getMaxMonthDate(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Log.e("date","----月末------="+day);
        ScheduleModel model = new ScheduleModel();
        model.setYear(year);
        model.setMonth(month);
        model.setDay(day);
        model.setDate(year+"-"+month+"-"+day);
        return model;
    }

    @Override
    public void findData(long date) {

        Observable.just(date)
                .map(new Func1<Long, ScheduleModel>() {
                    @Override
                    public ScheduleModel call(Long date) {

                        ScheduleModel start = getMinMonthDate(date);
                        ScheduleModel end = getMaxMonthDate(date);
                        if (start == null || end == null){
                            return null;
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date(date));
                        int year = start.getYear();
                        int month = start.getMonth();
                        int startDay = start.getDay();
                        int startWeek = start.getWeek();
                        int endDay = end.getDay();
                        int week = startWeek;
                        List<ScheduleModel> data = new ArrayList<>();
                        for (int i = 0; i < startWeek; i++) {
                            ScheduleModel model = new ScheduleModel();
                            model.setHide(true);
                            data.add(model);
                        }
                        for (int i = startDay; i <= endDay; i++) {
                            ScheduleModel model = new ScheduleModel();
                            model.setId(i);
                            model.setYear(year);
                            model.setMonth(month);
                            model.setDay(i);
                            model.setDate(year+"-"+month+"-"+i);
                            model.setWeek(startWeek);
                            if (i == calendar.get(Calendar.DAY_OF_MONTH)){
                                model.setChecked(true);
                            }
                            if (startWeek >= 7){
                                startWeek = 1;
                            }else{
                                startWeek++;
                            }
                            data.add(model);
                        }
                        ScheduleModel m = new ScheduleModel();
                        m.setYear(year);
                        m.setMonth(month);
                        m.setDay(year);
                        m.setWeek(week);
                        m.setScheduleData(data);
                        return m;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ScheduleModel>() {
                    @Override
                    public void call(ScheduleModel model) {

                        if (model == null || mView == null) {
                            return;
                        }
                        mView.setScheduleResult(model);
                    }
                });
    }
}
