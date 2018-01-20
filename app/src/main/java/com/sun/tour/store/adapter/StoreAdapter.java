package com.sun.tour.store.adapter;

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
 * Created by lenovo on 2018/1/20.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder>{

    private OnRecyclerViewItemClick mOnRecyclerViewItemClick;
    public void setOnRecyclerViewItemClick(OnRecyclerViewItemClick onRecyclerViewItemClick){
        this.mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }
    @Override
    public StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, null);
        StoreViewHolder storeViewHolder = new StoreViewHolder(itemView);
        return storeViewHolder;
    }

    @Override
    public void onBindViewHolder(StoreViewHolder holder, final int position) {
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
        return 1;
    }

    public class StoreViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.relative_item_store)
        RelativeLayout mRelativeLayout;
        public StoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
