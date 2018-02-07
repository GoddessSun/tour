package com.sun.tour.home.near;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/2/1.
 */

public class NearAdapter extends RecyclerView.Adapter<NearAdapter.NearViewHolder>{

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public NearAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NearViewHolder(inflater.inflate(R.layout.item_near_rv,null));
    }

    @Override
    public void onBindViewHolder(NearViewHolder holder, int position) {

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/tour/home/hotel_details_activity").navigation();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NearViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.home_near_item_layout)
        LinearLayout layout;
        public NearViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
