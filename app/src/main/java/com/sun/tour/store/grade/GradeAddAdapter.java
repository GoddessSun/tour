package com.sun.tour.store.grade;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/30.
 */

public class GradeAddAdapter extends RecyclerView.Adapter<GradeAddAdapter.GradeViewHolder>{

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public GradeAddAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public GradeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GradeViewHolder(inflater.inflate(R.layout.item_grade_add,null));
    }

    @Override
    public void onBindViewHolder(GradeViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class GradeViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.grade_add_tv)
        TextView tv;
        public GradeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
