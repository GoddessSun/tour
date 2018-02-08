package com.sun.tour.tourguide;

/**
 * Created by hanyg on 2018/2/8.
 */

public class GuideModel {


    private String title;
    private boolean show;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
