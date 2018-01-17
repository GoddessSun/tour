package com.sun.tour.appointment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.tour.R;

import butterknife.ButterKnife;

/**
 * Date: 2018/1/17
 * Time: 14:39
 * author: sunmingmao
 */

public class MyAppointmentAdapter extends RecyclerView.Adapter<MyAppointmentAdapter.MyAppointmentViewHolder>{


    @Override
    public MyAppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_appointment, null);
        MyAppointmentViewHolder myAppointmentViewHolder = new MyAppointmentViewHolder(itemView);
        return myAppointmentViewHolder;
    }

    @Override
    public void onBindViewHolder(MyAppointmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyAppointmentViewHolder extends RecyclerView.ViewHolder{
        public MyAppointmentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
