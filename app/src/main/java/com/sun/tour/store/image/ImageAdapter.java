package com.sun.tour.store.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/30.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;
    private OnImageCallBack onImageCallBack;
    private RequestOptions options;
    public ImageAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
        options = new RequestOptions();
        options.centerCrop()
                .error(R.drawable.img_guide_01)
                .placeholder(R.drawable.img_guide_02);
    }

    public void setOnImageCallBack(OnImageCallBack onImageCallBack) {
        this.onImageCallBack = onImageCallBack;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(inflater.inflate(R.layout.item_store_edit_image,null));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {

        if (position >= data.size()){
            Glide.with(context)
                    .load(R.drawable.ic_add_photo)
                    .into(holder.ivIcon);
        }else{
            Glide.with(context)
                    .setDefaultRequestOptions(options)
                    .load(data.get(position))
                    .into(holder.ivIcon);
        }
        holder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageCallBack == null){
                    return;
                }
                if (position >= data.size()){
                    onImageCallBack.addImage();
                }else{
                    onImageCallBack.onClickImage(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.store_edit_image_icon_tv)
        ImageView ivIcon;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    interface OnImageCallBack{

        void addImage();
        void onClickImage(int position);
    }
}
