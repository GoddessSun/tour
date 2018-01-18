package com.sun.tour.search.more;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import java.util.Calendar;

import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE+"/search/more/searchmore_activity")
public class SearchMoreActivity extends BaseActivity implements SearchMoreContract.View {

    private SearchMoreContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_more);

        init();
    }

    private void init() {

    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @Override
    public void bindPresenter(SearchMoreContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @OnClick({R.id.search_more_choice_time_tv})
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.search_more_choice_time_tv:
                showDatePicker();

                break;
        }
    }

    private void showDatePicker(){

        View view = getLayoutInflater().inflate(R.layout.item_search_more_choice_time,null);
        DatePicker dp = view.findViewById(R.id.search_more_choice_date_dp);
        TimePicker tp = view.findViewById(R.id.search_more_choice_time_tp);
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

        final BottomSheetDialog dialog = new BottomSheetDialog(this);
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
}
