package com.sun.tour.home.img;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;

/**
 * Created by hanyg on 2018/2/7.
 */

public class ImagePreviewUtil {

    public static void toActivity(ArrayList<String> data,int position){
        Bundle bun = new Bundle();
        bun.putStringArrayList("selected", data);
        bun.putInt("position",position);
        ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/home/img/imagepreview_activity")
                .with(bun)
                .navigation();
    }
}
