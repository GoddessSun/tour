package com.sun.tour.image;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hanyg on 2018/1/26.
 */

public class ChoiceImagePresenter implements ChoiceImageContract.Presenter {
    private ChoiceImageContract.View mView;
    private Context context;

    public ChoiceImagePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bindView(ChoiceImageContract.View view) {

        mView = view;
        view.bindPresenter(this);
    }

    @Override
    public void findLocalImage() {

        Observable.just("")
                .map(new Func1<String, List<ImageModel>>() {
                    @Override
                    public List<ImageModel> call(String s) {

                        try {
                            Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            ContentResolver mContentResolver = context.getContentResolver();
                            Cursor cursor = mContentResolver.query(mImageUri, null,
                                    MediaStore.Images.Media.MIME_TYPE + "=? or "
                                            + MediaStore.Images.Media.MIME_TYPE + "=?",
                                    new String[] { "image/jpeg", "image/png" },
                                    MediaStore.Images.Media.DATE_MODIFIED);
                            List<ImageModel> data = new ArrayList<>();
                            int count = 0;
                            while (cursor.moveToNext()){
                                // 获取图片的路径
                                String path = cursor.getString(cursor
                                        .getColumnIndex(MediaStore.Images.Media.DATA));
                                ImageModel model = new ImageModel();
                                model.setPath(path);
                                data.add(model);

                            }
                            cursor.close();
                            return data;
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        return null;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ImageModel>>() {
                    @Override
                    public void call(List<ImageModel> data) {

                        if (mView != null){
                            mView.setImageResult(data);
                        }
                    }
                });
    }

    @Override
    public void handlerCheckedImage(final ImageModel model, final List<ImageModel> clickData) {

        if (model == null || clickData == null){
            return;
        }
        Observable.just("")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {

                        if (model.isChecked()){
                            clickData.add(model);
                        }else{
                            for (int i = 0; i < clickData.size(); i++) {
                                ImageModel m = clickData.get(i);
                                if (m == null) {
                                    continue;
                                }
                                if (TextUtils.equals(model.getPath(),m.getPath())){
                                    clickData.remove(i);
                                    break;
                                }
                            }
                        }
                        int c = clickData.size();
                        String ss = null;
                        if (c == 0){
                            ss = "确定";
                        }else{
                            ss = "("+clickData.size()+"/9) 确定";
                        }
                        return ss;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                        if (mView != null){
                            mView.setClickImageResult(s);
                        }
                    }
                });
    }
}
