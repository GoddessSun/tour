package com.sun.tour.message.notify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.tour.R;

import java.util.List;

/**
 * Created by hanyg on 2018/2/7.
 */

public class SystemNotifyAdapter extends RecyclerView.Adapter<SystemNotifyAdapter.SystemNotifyViewHolder> {

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public SystemNotifyAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SystemNotifyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SystemNotifyViewHolder(inflater.inflate(R.layout.item_system_notify,null));
    }

    @Override
    public void onBindViewHolder(SystemNotifyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SystemNotifyViewHolder extends RecyclerView.ViewHolder{

        public SystemNotifyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
