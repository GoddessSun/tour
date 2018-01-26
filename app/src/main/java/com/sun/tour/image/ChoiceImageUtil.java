package com.sun.tour.image;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;

/**
 * Created by hanyg on 2018/1/26.
 */

public class ChoiceImageUtil {

    /**
     *
     * 选择单张图片
     *
     * @param activity
     * @param crop  是否进行裁剪
     * @param requestCode
     */
    public static void tophoto(BaseActivity activity,boolean crop,int requestCode){

        Bundle bundle = new Bundle();
        bundle.putInt("type",Constant.CHOICE_IMAGE.CHOICE_SINGLE_IMAGE);
        bundle.putBoolean("crop",crop);

        ARouter.getInstance()
                .build(Constant.ACTVIITY_ROUTE+"/image/choiceimage_activity")
                .with(bundle)
                .navigation(activity,requestCode);

    }

    /**
     *
     *
     * 选择多张图片
     *
     * @param activity
     * @param data   选中的图片列表
     * @param lintCount  限制最多选中图片的个数
     * @param requstCode
     */
    public static void tophoto(BaseActivity activity, ArrayList<String> data,int lintCount,int requstCode){

        Bundle bundle = new Bundle();
        bundle.putInt("type",Constant.CHOICE_IMAGE.CHOICE_MORE_IMAGE);
        bundle.putStringArrayList("checkedData",data);
        bundle.putInt("lintCount",lintCount);
        ARouter.getInstance()
                .build(Constant.ACTVIITY_ROUTE+"/image/choiceimage_activity")
                .with(bundle)
                .navigation(activity,requstCode);
    }
}
