package com.sun.tour.schedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/30.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private Context context;
    private List<ScheduleModel> data;
    private LayoutInflater inflater;

    public ScheduleAdapter(Context context, List<ScheduleModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScheduleViewHolder(inflater.inflate(R.layout.item_schedule_rv, null));
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {

        ScheduleModel model = data.get(position);
        if (model == null) {
            return;
        }

        holder.layout.setVisibility(View.VISIBLE);
        if (model.isHide()) {
            holder.layout.setVisibility(View.INVISIBLE);
        }
        if (model.getWeek() == 7 || model.getWeek() == 6){
            holder.tvDate.setTextColor(context.getResources().getColor(R.color.text_color999));
        }else{
            holder.tvDate.setTextColor(context.getResources().getColor(R.color.text_color333));
        }
        holder.tvDate.setText(""+model.getDay());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ScheduleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.schedule_item_layout)
        LinearLayout layout;
        @BindView(R.id.schedule_time_tv)
        TextView tvDate;
        @BindView(R.id.schedule_price_tv)
        TextView tvPrice;
        @BindView(R.id.schedule_line)
        View line;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
