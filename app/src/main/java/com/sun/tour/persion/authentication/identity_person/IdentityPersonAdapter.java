package com.sun.tour.persion.authentication.identity_person;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.tour.R;

import java.util.List;

/**
 * Created by hanyg on 2018/2/5.
 */

public class IdentityPersonAdapter extends RecyclerView.Adapter<IdentityPersonAdapter.IdentityPersonViewHolder>{

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public IdentityPersonAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public IdentityPersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IdentityPersonViewHolder(inflater.inflate(R.layout.item_identity_person,null));
    }

    @Override
    public void onBindViewHolder(IdentityPersonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class IdentityPersonViewHolder extends RecyclerView.ViewHolder{

        public IdentityPersonViewHolder(View itemView) {
            super(itemView);
        }
    }
}
