package com.sun.tour.appointment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.tour.R;

import butterknife.ButterKnife;

/**
 * Date: 2018/1/17
 * Time: 15:56
 * author: sunmingmao
 */

public class AppointmentMineAdapter extends RecyclerView.Adapter<AppointmentMineAdapter.AppointmentMineViewHolder>{

    @Override
    public AppointmentMineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment_mine, null);
        AppointmentMineViewHolder appointmentMineViewHolder = new AppointmentMineViewHolder(itemView);
        return appointmentMineViewHolder;
    }

    @Override
    public void onBindViewHolder(AppointmentMineViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class AppointmentMineViewHolder extends RecyclerView.ViewHolder{
        public AppointmentMineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
