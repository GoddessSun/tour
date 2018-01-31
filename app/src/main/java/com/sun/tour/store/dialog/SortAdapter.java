package com.sun.tour.store.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/30.
 */

public class SortAdapter extends RecyclerView.Adapter<SortAdapter.SortViewHolder>{

    private Context context;
    private List<BrandModel> data;
    private LayoutInflater inflater;

    public SortAdapter(Context context, List<BrandModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SortViewHolder(inflater.inflate(R.layout.item_species_sort,null));
    }

    @Override
    public void onBindViewHolder(SortViewHolder holder, int position) {

        BrandModel model = data.get(position);
        if (model != null) {
            if (model.isChecked()){
                holder.tvTitle.setVisibility(View.VISIBLE);
            }else{
                holder.tvTitle.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SortViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.brand_sort_title_tv)
        TextView tvTitle;
        @BindView(R.id.brand_sort_checked_iv)
        ImageView ivChecked;
        @BindView(R.id.brand_sort_tv)
        TextView tvSort;
        @BindView(R.id.brand_sort_remark_tv)
        TextView tvRemark;

        public SortViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
