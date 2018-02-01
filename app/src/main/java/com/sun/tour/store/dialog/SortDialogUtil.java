package com.sun.tour.store.dialog;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sun.tour.R;

import java.util.ArrayList;
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
}
