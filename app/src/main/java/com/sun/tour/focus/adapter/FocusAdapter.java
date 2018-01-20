package com.sun.tour.focus.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sun.tour.OnRecyclerViewItemClick;
import com.sun.tour.R;
import com.sun.tour.TourApplation;
import com.sun.tour.focus.callback.OnItemCancleClick;
import com.sun.tour.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/1/20.
 */

public class FocusAdapter extends RecyclerView.Adapter<FocusAdapter.FocusViewHolder>{

    private OnRecyclerViewItemClick mOnRecyclerViewItemClick;
    private OnItemCancleClick mOnItemCancleClick;

    public void setOnRecyclerViewItemClick(OnRecyclerViewItemClick onRecyclerViewItemClick){
        this.mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }
    public void setOnItemCancleClick(OnItemCancleClick onItemCancleClick){
        this.mOnItemCancleClick = onItemCancleClick;
    }

    @Override
    public FocusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_focus, null);
        FocusViewHolder focusViewHolder = new FocusViewHolder(itemView);
        return focusViewHolder;
    }

    @Override
    public void onBindViewHolder(FocusViewHolder holder, final int position) {
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnRecyclerViewItemClick!=null){
                    mOnRecyclerViewItemClick.onItemRecyclerViewClick(position);
                }
            }
        });
        holder.mCancleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemCancleClick!=null){
                    mOnItemCancleClick.onCancleClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class FocusViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.relative_item_focus)
        RelativeLayout mRelativeLayout;
        @BindView(R.id.text_item_focus_cancle)
        TextView mCancleTextView;
        public FocusViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
            layoutParams.width = (CommonUtil.getScreenDisplay(TourApplation.getAppContext())[0] - CommonUtil.dip2px(TourApplation.getAppContext(),30))/2;
            mRelativeLayout.setLayoutParams(layoutParams);
        }
    }

}
