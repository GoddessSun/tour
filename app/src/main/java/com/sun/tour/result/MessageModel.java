package com.sun.tour.result;

/**
 *
 *
 * 消息列表界面
 *
 * Created by hanyg on 2018/1/25.
 */

public class MessageModel {

    private String name;
    private String content;
    private String time;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
