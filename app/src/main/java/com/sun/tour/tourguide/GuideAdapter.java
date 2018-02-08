package com.sun.tour.tourguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/2/8.
 */

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {

    private Context context;
    private List<GuideModel> data;
    private LayoutInflater inflater;

    public GuideAdapter(Context context, List<GuideModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GuideViewHolder(inflater.inflate(R.layout.item_guide_list,null));
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, int position) {

        GuideModel model = data.get(position);
        if (model != null) {
            if (model.isShow()) {
                holder.tvTitle.setVisibility(View.VISIBLE);
                holder.tvTitle.setText(model.getTitle());
            }else{
                holder.tvTitle.setVisibility(View.GONE);
            }
            holder.tvContent.setText(model.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class GuideViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.guide_title_tv)
        TextView tvTitle;
        @BindView(R.id.guide_content_tv)
        TextView tvContent;

        public GuideViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
