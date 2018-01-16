package com.sun.tour.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.tour.R;

import butterknife.ButterKnife;

/**
 * Date: 2018/1/12
 * Time: 10:48
 * author: sunmingmao
 */

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder>{


    @Override
    public NearbyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_nearby, null);
        NearbyViewHolder nearbyViewHolder = new NearbyViewHolder(mItemView);
        return nearbyViewHolder;
    }

    @Override
    public void onBindViewHolder(NearbyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class NearbyViewHolder extends RecyclerView.ViewHolder{
        public NearbyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
