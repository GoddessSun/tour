package com.sun.tour.message;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.tour.R;
import com.sun.tour.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/19.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public MessageAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(inflater.inflate(R.layout.item_message_list, null));
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/message/chat/chat_activity").navigation();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.message_icon_iv)
        ImageView ivIcon;
        @BindView(R.id.message_name_tv)
        TextView tvName;
        @BindView(R.id.message_time_tv)
        TextView tvTime;
        @BindView(R.id.message_content_tv)
        TextView tvContent;
        @BindView(R.id.message_list_layout)
        RelativeLayout layout;

        public MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
