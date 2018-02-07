package com.sun.tour.store.dialog;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.sun.tour.R;
import com.sun.tour.view.WDatePicket;
import com.sun.tour.view.WTimePicket;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hanyg on 2018/1/30.
 */

public class SortDialogUtil {


    public static void showBrandDialog(Context context){

        List<BrandModel> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                BrandModel model = new BrandModel();
                if (j == 0){
                    model.setChecked(true);
                }else{
                    model.setChecked(false);
                }
                data.add(model);
            }
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_brand_dialog,null);
        int height = context.getResources().getDisplayMetrics().heightPixels;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height/2);
        view.setLayoutParams(params);
        RecyclerView rv = view.findViewById(R.id.species_brand_dialog_rv);
        Button btn = view.findViewById(R.id.species_brand_dialog_bottom_btn);
        rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        SortAdapter sortAdapter = new SortAdapter(context,data);
        rv.setAdapter(sortAdapter);
        BottomSheetDialog dialog = new BottomSheetDialog(context);
        dialog.setContentView(view);
        dialog.show();
    }

    public static void showDate_TimeDialog(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_more_choice_time,null);
        WDatePicket dp = view.findViewById(R.id.search_more_choice_date_dp);
        WTimePicket tp = view.findViewById(R.id.search_more_choice_time_tp);

        tp.setIs24HourView(true);
        Calendar calendar = Calendar.getInstance();
        dp.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Log.e("date","----year-----"+year+"---monthOfYear---"+monthOfYear+"-----dayOfMonth----"+dayOfMonth);
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Log.e("time","----hourOfDay-----"+hourOfDay+"---minute---"+minute);
            }
        });

        final BottomSheetDialog dialog = new BottomSheetDialog(context);
        dialog.setContentView(view);
        view.findViewById(R.id.search_more_choice_dt__cancel_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.search_more_choice_dt__finish_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void showComputeCostDialog(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_compute_cost_dialog,null);

        BottomSheetDialog dialog = new BottomSheetDialog(context);
        dialog.setContentView(view);
        dialog.show();
    }

    public static void showCancelDialog(Context context,String title,String message,OnCancelCallBack onCancelCallBack){

        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_cancel,null);
        LinearLayout titleLayout = view.findViewById(R.id.dialog_cancel_title_layout);
        TextView tvTitle = view.findViewById(R.id.dialog_cancel_title_tv);
        TextView tvMessage = view.findViewById(R.id.dialog_cancel_message_tv);
        Button btnCancel = view.findViewById(R.id.dialog_cancel_btn);
        Button btnFinish = view.findViewById(R.id.dialog_cancel_finish_btn);
        if (!TextUtils.isEmpty(title)){
            tvTitle.setText(title);
        }
        tvMessage.setText(message);

        final BottomSheetDialog dialog = new BottomSheetDialog(context);
        dialog.setContentView(view);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    interface OnCancelCallBack{

        void dialogCancel();
        void dialogFinish();
    }
}
