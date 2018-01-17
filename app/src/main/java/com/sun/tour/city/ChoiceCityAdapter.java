package com.sun.tour.city;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/16.
 */

public class ChoiceCityAdapter extends BaseAdapter {

    private Context context;
    private List<ChoiceCityModel> data;
    private LayoutInflater inflater;

    public ChoiceCityAdapter(Context context, List<ChoiceCityModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_choice_city, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ChoiceCityModel model = data.get(position);
        if (model != null) {

            if (model.isShow()) {
                vh.tvHeader.setVisibility(View.VISIBLE);
            }else{
                vh.tvHeader.setVisibility(View.GONE);
            }
            vh.tvHeader.setText(model.getFirst());
            vh.tvName.setText(model.getName());
        }
        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.choice_city_header_tv)
        TextView tvHeader;
        @BindView(R.id.choice_city_name_tv)
        TextView tvName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
