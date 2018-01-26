package com.sun.tour.image;

/**
 * Created by hanyg on 2018/1/26.
 */

public class ImageModel {

    private String path;
    private boolean checked;
    //默认为图片，1，照相机
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
