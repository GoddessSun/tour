package com.sun.tour.store.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

    public ImageAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(inflater.inflate(R.layout.item_store_edit_image,null));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        if (position >= data.size()){
            holder.ivIcon.setImageResource(R.drawable.ic_add_image);
        }else{
            holder.ivIcon.setImageResource(R.drawable.img_guide_02);
        }

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
}
