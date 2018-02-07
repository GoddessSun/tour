package com.sun.tour.store.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.OnRecyclerViewItemClick;
import com.sun.tour.R;
import com.sun.tour.store.dialog.SortDialogUtil;
import com.sun.tour.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/1/20.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder>{

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public StoreAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

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

        holder.editLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/store/store_edit/storeedit_acitivity").navigation();
            }
        });
        holder.dateEditLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SortDialogUtil.showDate_TimeDialog(context);
            }
        });

        holder.deleteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SortDialogUtil.showCancelDialog(context,null,"是否删除该店铺?",null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class StoreViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.relative_item_store)
        RelativeLayout mRelativeLayout;
        @BindView(R.id.store_edit_layout)
        LinearLayout editLayout;
        @BindView(R.id.store_date_edit_layout)
        LinearLayout dateEditLayout;
        @BindView(R.id.store_delete_layout)
        LinearLayout deleteLayout;

        public StoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
