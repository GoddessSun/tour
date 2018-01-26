package com.sun.tour.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sun.tour.R;
import com.sun.tour.utils.Constant;
import com.sun.tour.view.TRelativeLayout;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/26.
 */

public class ChoiceImageAdapter extends RecyclerView.Adapter<ChoiceImageAdapter.ChoiceImageViewHolder> {

    private Context context;
    private List<ImageModel> data;
    private LayoutInflater inflater;
    private ClickCallBack clickCallBack;
    private int type;
    public ChoiceImageAdapter(Context context, List<ImageModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setClickCallBack(ClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    @Override
    public ChoiceImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChoiceImageViewHolder(inflater.inflate(R.layout.item_choice_image,null));
    }

    @Override
    public void onBindViewHolder(ChoiceImageViewHolder holder, final int position) {

        final ImageModel model = data.get(position);
        if (model != null) {
            if (type == Constant.CHOICE_IMAGE.CHOICE_SINGLE_IMAGE){
                holder.ivChecked.setVisibility(View.GONE);
                holder.view.setVisibility(View.GONE);
                if (model.getType() == 1){
                    Glide.with(context)
                            .load(R.drawable.ic_camera)
                            .into(holder.ivIcon);
                }else{
                    Glide.with(context)
                            .load(new File(model.getPath()))
                            .into(holder.ivIcon);
                }
            }else{
                holder.ivChecked.setVisibility(View.VISIBLE);
                if (model.isChecked()){
                    holder.view.setVisibility(View.VISIBLE);
                    holder.ivChecked.setImageResource(R.drawable.ic_checked);
                }else{
                    holder.view.setVisibility(View.GONE);
                    holder.ivChecked.setImageResource(R.drawable.ic_no_checked);
                }
                Glide.with(context)
                        .load(new File(model.getPath()))
                        .into(holder.ivIcon);
            }

            holder.ivChecked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickCallBack != null){
                        clickCallBack.click(position,model);
                    }
                }
            });
            holder.ivIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (clickCallBack == null) {
                        return;
                    }
                    if (type == Constant.CHOICE_IMAGE.CHOICE_SINGLE_IMAGE){
                        if (model.getType() == 1){
                            clickCallBack.camera();
                        }
                    }else{
                        clickCallBack.click(position,model);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ChoiceImageViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.choice_image_check_layout)
        TRelativeLayout relativeLayout;
        @BindView(R.id.choice_image_list_iv)
        ImageView ivIcon;
        @BindView(R.id.choice_image_check_bg_view)
        View view;
        @BindView(R.id.choice_image_check_iv)
        ImageView ivChecked;
        public ChoiceImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    interface ClickCallBack{

        void click(int position,ImageModel model);
        void camera();

    }
}
