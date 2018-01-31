package com.sun.tour.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
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
 * Date: 2018/1/31
 * Time: 16:33
 * author: sunmingmao
 */

public class SelectDialogUtils {
    private Context mContext;
    private List<String> mDataList;
    private final BottomSheetDialog mBottomSheetDialog;
    private final DialogAdapter mDialogAdapter;
    private OnItemDialogClick mOnItemDialogClick;
    public SelectDialogUtils(Context context,List<String> mDataList) {
        mContext = context;
        this.mDataList = mDataList;
        mBottomSheetDialog = new BottomSheetDialog(mContext);
        mDialogAdapter = new DialogAdapter(mDataList);
        init();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_selected, null);
        mBottomSheetDialog.setContentView(view);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_dialog_bottom);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mDialogAdapter);
    }

    public void showDialog(){
        mBottomSheetDialog.show();
    }

    public void dismissDialog(){
        mBottomSheetDialog.dismiss();
    }


    public void setOnItemDialogClick(OnItemDialogClick onItemDialogClick){
        this.mOnItemDialogClick = onItemDialogClick;
    }

    public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder>{
        private List<String> mStringList;


        public DialogAdapter(List<String> stringList) {
            mStringList = stringList;
        }


        @Override
        public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_bottom, null);
            DialogViewHolder dialogViewHolder = new DialogViewHolder(itemView);
            return dialogViewHolder;
        }

        @Override
        public void onBindViewHolder(DialogViewHolder holder, final int position) {
            if (position == (mStringList.size()-1)){
                holder.mTextView.setTextColor(Color.parseColor("#4574f0"));
                holder.mView.setVisibility(View.INVISIBLE);
            }else {
                holder.mView.setVisibility(View.VISIBLE);
                if (position == (mStringList.size()-2)){
                    ViewGroup.LayoutParams layoutParams = holder.mView.getLayoutParams();
                    layoutParams.height = CommonUtil.dip2px(mContext,10);
                    holder.mView.setLayoutParams(layoutParams);
                }else {
                    ViewGroup.LayoutParams layoutParams = holder.mView.getLayoutParams();
                    layoutParams.height = 4;
                    holder.mView.setLayoutParams(layoutParams);
                }

            }

            holder.mTextView.setText(mStringList.get(position));
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemDialogClick!=null){
                        mOnItemDialogClick.onClick(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mStringList == null ? 0 : mStringList.size();
        }

        public class DialogViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.text_item_dialog_bottom)
            TextView mTextView;
            @BindView(R.id.view_line_item_bottom_dialog)
            View mView;
            public DialogViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);

            }
        }

    }
    public interface OnItemDialogClick{
        void onClick(int position);
    }
}
