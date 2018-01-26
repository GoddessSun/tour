package com.sun.tour.message.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.sun.tour.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hanyg on 2018/1/25.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public ChatAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatViewHolder(inflater.inflate(R.layout.item_chat_list,null));
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {

        holder.leftLayout.setVisibility(View.GONE);
        holder.timeLayout.setVisibility(View.GONE);
        holder.rightLayout.setVisibility(View.GONE);
        if (position%5 == 0){
            holder.timeLayout.setVisibility(View.VISIBLE);
        }
        if (position %2 == 0){
            holder.leftLayout.setVisibility(View.VISIBLE);
        }else{
            holder.rightLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.chat_list_message_time_layout)
        LinearLayout timeLayout;


        @BindView(R.id.chat_list_message_time_tv)
        TextView tvTime;
        @BindView(R.id.chat_list_left_layout)
        RelativeLayout leftLayout;
        @BindView(R.id.chat_list_left_icon_iv)
        RoundedImageView ivLeftIcon;
        @BindView(R.id.chat_list_left_message_layout)
        LinearLayout leftMessageLayout;
        @BindView(R.id.chat_list_left_content_tv)
        TextView tvLeftMessage;


        @BindView(R.id.chat_list_right_layout)
        RelativeLayout rightLayout;
        @BindView(R.id.chat_list_right_icon_iv)
        ImageView ivRightIcon;
        @BindView(R.id.chat_list_right_message_layout)
        LinearLayout rightMessageLayout;
        @BindView(R.id.chat_list_right_content_tv)
        TextView tvRightMessage;

        public ChatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
