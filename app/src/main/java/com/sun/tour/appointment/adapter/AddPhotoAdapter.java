package com.sun.tour.appointment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sun.tour.R;
import com.sun.tour.TourApplation;
import com.sun.tour.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Date: 2018/2/1
 * Time: 9:31
 * author: sunmingmao
 */

public class AddPhotoAdapter extends RecyclerView.Adapter<AddPhotoAdapter.AddPhotoViewHolder>{

    private List<String> mImagePathList;

    public AddPhotoAdapter(List<String> imagePathList) {
        mImagePathList = imagePathList;
    }

    @Override
    public AddPhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_photo, null);
        AddPhotoViewHolder addPhotoViewHolder = new AddPhotoViewHolder(itemView);
        return addPhotoViewHolder;
    }

    @Override
    public void onBindViewHolder(AddPhotoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mImagePathList == null ? 1 : mImagePathList.size()+1;
    }

    public class AddPhotoViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image_item_add_photo)
        ImageView mImageView;
        public AddPhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            ViewGroup.LayoutParams layoutParams = mImageView.getLayoutParams();
            int screenWidth = CommonUtil.getScreenDisplay(TourApplation.getAppContext())[0];
            int width = screenWidth-(CommonUtil.dip2px(TourApplation.getAppContext(),16*4));
            layoutParams.width = width;
            mImageView.setLayoutParams(layoutParams);
        }
    }
}
