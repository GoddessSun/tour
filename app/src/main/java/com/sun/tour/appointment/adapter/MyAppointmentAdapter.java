package com.sun.tour.appointment.adapter;

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
 * Date: 2018/1/17
 * Time: 14:39
 * author: sunmingmao
 */

public class MyAppointmentAdapter extends RecyclerView.Adapter<MyAppointmentAdapter.MyAppointmentViewHolder>{

    private OnRecyclerViewItemClick mOnRecyclerViewItemClick;

    public void setmOnRecyclerViewItemClick(OnRecyclerViewItemClick onRecyclerViewItemClick){
        this.mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }

    @Override
    public MyAppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_appointment, null);
        MyAppointmentViewHolder myAppointmentViewHolder = new MyAppointmentViewHolder(itemView);
        return myAppointmentViewHolder;
    }

    @Override
    public void onBindViewHolder(MyAppointmentViewHolder holder, final int position) {
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
        return 10;
    }

    public class MyAppointmentViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.relative_content_item_my_appointment)
        RelativeLayout mRelativeLayout;
        public MyAppointmentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
