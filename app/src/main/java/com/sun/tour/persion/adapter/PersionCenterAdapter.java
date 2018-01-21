package com.sun.tour.persion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sun.tour.R;

/**
 * Created by lenovo on 2018/1/21.
 */

public class PersionCenterAdapter extends RecyclerView.Adapter<PersionCenterAdapter.PersionViewHolder>{

    @Override
    public PersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persion_center, null);
        PersionViewHolder persionViewHolder = new PersionViewHolder(itemView);
        return persionViewHolder;
    }

    @Override
    public void onBindViewHolder(PersionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class PersionViewHolder extends RecyclerView.ViewHolder{
        public PersionViewHolder(View itemView) {
            super(itemView);
        }
    }
}
