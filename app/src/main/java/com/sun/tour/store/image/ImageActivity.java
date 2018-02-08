package com.sun.tour.store.image;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.home.img.ImagePreviewUtil;
import com.sun.tour.imageselector.utils.ImageSelectorUtils;
import com.sun.tour.utils.Constant;
import com.sun.tour.utils.SelectDialogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE + "/store/image/image_activity")
public class ImageActivity extends BaseActivity {

    @BindView(R.id.store_edit_image_rv)
    RecyclerView rv;
    private List<String> data = new ArrayList<>();
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {

        rv.setLayoutManager(new GridLayoutManager(this,4));
        mAdapter = new ImageAdapter(this,data);
        rv.setAdapter(mAdapter);
        setListener();
    }

    private void setListener() {
        mAdapter.setOnImageCallBack(new ImageAdapter.OnImageCallBack() {
            @Override
            public void addImage() {
                final SelectDialogUtils selectDialogUtils = new SelectDialogUtils(ImageActivity.this, Arrays.asList("相机","从相册中选择","取消"));
                selectDialogUtils.showDialog();
                selectDialogUtils.setOnItemDialogClick(new SelectDialogUtils.OnItemDialogClick() {
                    @Override
                    public void onClick(int position) {
                        selectDialogUtils.dismissDialog();
                        switch (position){
                            case 0:
                                break;
                            case 1:
                                ImageSelectorUtils.openPhoto(ImageActivity.this,101,false,9,null);
                                break;
                            case 2:
                                break;
                        }
                    }
                });
            }

            @Override
            public void onClickImage(int position) {
                ImagePreviewUtil.toActivity((ArrayList<String>) data,position);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null || resultCode != RESULT_OK){
            return;
        }
        switch (requestCode){
            case 101:
                ArrayList<String> paths = data.getStringArrayListExtra(ImageSelectorUtils.SELECT_RESULT);
                if (paths != null){
                    this.data.addAll(paths);
                    mAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @OnClick({R.id.store_edit_image_back_iv, R.id.store_edit_image_save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_image_back_iv:
                finish();
                break;
            case R.id.store_edit_image_save_tv:
                break;
        }
    }
}
