package com.sun.tour.schedule;

import java.util.List;

/**
 * Created by hanyg on 2018/1/30.
 */

public class ScheduleModel {

    private int id;
    private int year;
    private int month;
    private int day;
    private int week;
    private String price;
    private boolean hide ;
    private String date;
    private boolean checked;
    private List<ScheduleModel> scheduleData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<ScheduleModel> getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(List<ScheduleModel> scheduleData) {
        this.scheduleData = scheduleData;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }
}
