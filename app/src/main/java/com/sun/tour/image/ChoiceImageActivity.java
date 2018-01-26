package com.sun.tour.image;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;
import com.sun.tour.view.RxToast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 *
 * 选择图片
 *
 */
@Route(path = Constant.ACTVIITY_ROUTE+"/image/choiceimage_activity")
public class ChoiceImageActivity extends BaseActivity implements ChoiceImageContract.View{

    @BindView(R.id.choice_image_finish_tv)
    TextView tvFinish;
    @BindView(R.id.choice_image_rv)
    RecyclerView rv;

    private List<ImageModel> data = new ArrayList<>();
    private ChoiceImageContract.Presenter presenter;
    private ChoiceImageAdapter mAdapter;
    private List<ImageModel> clickData = new ArrayList<>();
    private int lintCount;
    private ArrayList<String> checkedData;
    private boolean crop;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_image);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {

        ChoiceImagePresenter choiceImagePresenter = new ChoiceImagePresenter(this);
        choiceImagePresenter.bindView(this);
        getIntentData();
        rv.setLayoutManager(new GridLayoutManager(this,3));
        mAdapter = new ChoiceImageAdapter(this,data);
        mAdapter.setType(type);
        rv.setAdapter(mAdapter);
        setListener();
        presenter.findLocalImage();
    }

    private void setListener() {

        mAdapter.setClickCallBack(new ChoiceImageAdapter.ClickCallBack() {
            @Override
            public void click(int position, ImageModel model) {

                if (type == Constant.CHOICE_IMAGE.CHOICE_SINGLE_IMAGE){

                }else{
                    model.setChecked(!model.isChecked());
                    mAdapter.notifyDataSetChanged();
                    presenter.handlerCheckedImage(model,clickData);
                }
            }

            @Override
            public void camera() {

                if (judgeCameraPermission()){
                    File outputImage = new File(Environment.getExternalStorageDirectory(),
                            "tempImage" + ".jpg");
                    try {
                        if (outputImage.exists()) {
                            outputImage.delete();
                        }
                        outputImage.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Uri imageUri = Uri.fromFile(outputImage);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 10);
                }
            }
        });
    }

    private boolean judgeCameraPermission(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

                RxToast.showToast("您已禁止拍照权限，请到设置->应用管理修改权限");
                return false;
            }
        }
        return true;
    }
    private void getIntentData() {
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null){
            return;
        }
        Bundle bundle = intent.getExtras();
        type = bundle.getInt("type",0);

        if (type == Constant.CHOICE_IMAGE.CHOICE_SINGLE_IMAGE){
            crop = bundle.getBoolean("crop",false);

        }else if (type == Constant.CHOICE_IMAGE.CHOICE_MORE_IMAGE){
            checkedData = bundle.getStringArrayList("checkedData");
            lintCount = bundle.getInt("lintCount");
        }
    }

    @OnClick({R.id.choice_image_back_tv,R.id.choice_image_finish_tv})
    public void onClick(View view){

        switch (view.getId()) {
            case R.id.choice_image_back_tv:
                finish();
                break;
            case R.id.choice_image_finish_tv:
                break;
        }
    }

    private void initData(){
        data.clear();
        if (type == Constant.CHOICE_IMAGE.CHOICE_SINGLE_IMAGE) {
            ImageModel model = new ImageModel();
            model.setType(1);
            data.add(model);
        }

    }
    @Override
    public void bindPresenter(ChoiceImageContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void setImageResult(List<ImageModel> data) {
        initData();
        if (data != null){
            this.data.addAll(data);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setClickImageResult(String s) {
        tvFinish.setText(s);
    }
}
