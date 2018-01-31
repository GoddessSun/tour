package com.sun.tour.store.address;

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

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public AddressAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AddressViewHolder(inflater.inflate(R.layout.item_store_address, null));
    }

    @Override
    public void onBindViewHolder(AddressViewHolder holder, int position) {

        holder.line.setVisibility(View.VISIBLE);
        if (position == data.size() -1){
            holder.line.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class AddressViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.store_address_name_tv)
        TextView tvName;
        @BindView(R.id.store_address_handler_tv)
        TextView tvHandler;
        @BindView(R.id.store_address_edit_tv)
        TextView tvEdit;
        @BindView(R.id.store_address_info_tv)
        TextView tvInfo;
        @BindView(R.id.store_address_line)
        View line;
        public AddressViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
