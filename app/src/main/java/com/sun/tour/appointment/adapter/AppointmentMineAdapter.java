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
 * Time: 15:56
 * author: sunmingmao
 */

public class AppointmentMineAdapter extends RecyclerView.Adapter<AppointmentMineAdapter.AppointmentMineViewHolder>{

    private OnRecyclerViewItemClick mOnRecyclerViewItemClick;
    public void setmOnRecyclerViewItemClick(OnRecyclerViewItemClick onRecyclerViewItemClick){
        this.mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }
    @Override
    public AppointmentMineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment_mine, null);
        AppointmentMineViewHolder appointmentMineViewHolder = new AppointmentMineViewHolder(itemView);
        return appointmentMineViewHolder;
    }

    @Override
    public void onBindViewHolder(AppointmentMineViewHolder holder, final int position) {
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

    public class AppointmentMineViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.relative_item_appoint_mine)
        RelativeLayout mRelativeLayout;
        public AppointmentMineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }



}
