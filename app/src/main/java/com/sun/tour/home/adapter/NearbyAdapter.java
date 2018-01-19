package com.sun.tour.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.sun.tour.OnRecyclerViewItemClick;
import com.sun.tour.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Date: 2018/1/12
 * Time: 10:48
 * author: sunmingmao
 */

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder>{

    private OnRecyclerViewItemClick mOnRecyclerViewItemClick;
    public void setmOnRecyclerViewItemClick(OnRecyclerViewItemClick onRecyclerViewItemClick){
        this.mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }

    @Override
    public NearbyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_nearby, null);
        NearbyViewHolder nearbyViewHolder = new NearbyViewHolder(mItemView);
        return nearbyViewHolder;
    }

    @Override
    public void onBindViewHolder(NearbyViewHolder holder, final int position) {
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnRecyclerViewItemClick!=null){
                    mOnRecyclerViewItemClick.onItemRecyclerViewClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class NearbyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.relative_item_nearby)
        RelativeLayout mRelativeLayout;
        public NearbyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
