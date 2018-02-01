package com.sun.tour.schedule;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE+"/schedule/schedule_activity")
public class ScheduleActivity extends BaseActivity implements ScheduleContract.View{

    @BindView(R.id.schedule_add_tv)
    TextView tvAdd;
    @BindView(R.id.schedule_first_tv)
    TextView tvFirst;
    @BindView(R.id.schedule_first_layout)
    LinearLayout layoutFirst;
    @BindView(R.id.schedule_second_tv)
    TextView tvSecond;
    @BindView(R.id.schedule_second_layout)
    LinearLayout layoutSecond;
    @BindView(R.id.schedule_three_tv)
    TextView tvThree;
    @BindView(R.id.schedule_three_layout)
    LinearLayout layoutThree;
    @BindView(R.id.schedule_fourth_tv)
    TextView tvFourth;
    @BindView(R.id.schedule_fourth_layout)
    LinearLayout layoutFourth;
    @BindView(R.id.schedule_fifth_tv)
    TextView tvFifth;
    @BindView(R.id.schedule_fifth_layout)
    LinearLayout layoutFifth;
    @BindView(R.id.schedule_sexth_tv)
    TextView tvSexth;
    @BindView(R.id.schedule_sexth_layout)
    LinearLayout layoutSexth;
    @BindView(R.id.schedule_seventh_tv)
    TextView tvSeventh;
    @BindView(R.id.schedule_seventh_layout)
    LinearLayout layoutSeventh;
    @BindView(R.id.schedule_rv)
    RecyclerView rv;

    private List<ScheduleModel> data = new ArrayList<>();
    private ScheduleAdapter mAdapter;
    private ScheduleContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {
        SchedulePresenter schedulePresenter = new SchedulePresenter(this);
        schedulePresenter.bindView(this);
        rv.setLayoutManager(new GridLayoutManager(this,7));
        mAdapter = new ScheduleAdapter(this,data);
        rv.setAdapter(mAdapter);
        presenter.findData(System.currentTimeMillis());

    }

    @OnClick({R.id.schedule_add_tv,R.id.schedule_back_iv,R.id.store_schedule_save_tv})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.schedule_back_iv:
                finish();
                break;
            case R.id.store_schedule_save_tv:
                break;
            case R.id.schedule_add_tv:
                break;
        }
    }

    @Override
    public void bindPresenter(ScheduleContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void setScheduleResult(ScheduleModel model) {


        if (model == null) {
            return;
        }
        data.clear();
        if (model.getScheduleData() != null && !model.getScheduleData().isEmpty()){
            data.addAll(model.getScheduleData());
        }
        mAdapter.notifyDataSetChanged();
        setMonthVisible(model);
    }

    private void setMonthVisible(ScheduleModel model){

        switch (model.getWeek()){
            case 1:
                setMondayVisible(model.getMonth());
                break;
            case 2:
                setTuesdayVisible(model.getMonth());
                break;
            case 3:
                setWednesdayVisible(model.getMonth());
                break;
            case 4:
                setThursdayVisible(model.getMonth());
                break;
            case 5:
                setFridayVisible(model.getMonth());
                break;
            case 6:
                setSaturdayVisible(model.getMonth());
                break;
            case 7:
                setSundayVisible(model.getMonth());
                break;
        }
    }

    private void setSaturdayVisible(int month) {
        layoutFirst.setVisibility(View.INVISIBLE);

        layoutSecond.setVisibility(View.INVISIBLE);

        layoutThree.setVisibility(View.INVISIBLE);

        layoutFourth.setVisibility(View.INVISIBLE);

        layoutFifth.setVisibility(View.INVISIBLE);

        layoutSexth.setVisibility(View.INVISIBLE);

        layoutSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setText(month+"月");
    }

    private void setFridayVisible(int month) {
        layoutFirst.setVisibility(View.INVISIBLE);

        layoutSecond.setVisibility(View.INVISIBLE);

        layoutThree.setVisibility(View.INVISIBLE);

        layoutFourth.setVisibility(View.INVISIBLE);

        layoutFifth.setVisibility(View.INVISIBLE);

        layoutSexth.setVisibility(View.VISIBLE);
        tvSexth.setVisibility(View.VISIBLE);
        tvSexth.setText(month+"月");

        layoutSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setText("");
    }

    private void setThursdayVisible(int month) {

        layoutFirst.setVisibility(View.INVISIBLE);

        layoutSecond.setVisibility(View.INVISIBLE);

        layoutThree.setVisibility(View.INVISIBLE);

        layoutFourth.setVisibility(View.INVISIBLE);

        layoutFifth.setVisibility(View.VISIBLE);
        tvFifth.setVisibility(View.VISIBLE);
        tvFifth.setText(month+"月");

        layoutSexth.setVisibility(View.VISIBLE);
        tvSexth.setVisibility(View.VISIBLE);
        tvSexth.setText("");

        layoutSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setText("");
    }

    private void setWednesdayVisible(int month) {
        layoutFirst.setVisibility(View.INVISIBLE);

        layoutSecond.setVisibility(View.INVISIBLE);

        layoutThree.setVisibility(View.INVISIBLE);

        layoutFourth.setVisibility(View.VISIBLE);
        tvFourth.setVisibility(View.VISIBLE);
        tvFourth.setText(month+"月");

        layoutFifth.setVisibility(View.VISIBLE);
        tvFifth.setVisibility(View.VISIBLE);
        tvFifth.setText("");

        layoutSexth.setVisibility(View.VISIBLE);
        tvSexth.setVisibility(View.VISIBLE);
        tvSexth.setText("");

        layoutSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setText("");
    }

    private void setTuesdayVisible(int month) {
        layoutFirst.setVisibility(View.INVISIBLE);

        layoutSecond.setVisibility(View.INVISIBLE);

        layoutThree.setVisibility(View.VISIBLE);
        tvThree.setVisibility(View.VISIBLE);
        tvThree.setText(month+"月");

        layoutFourth.setVisibility(View.VISIBLE);
        tvFourth.setVisibility(View.VISIBLE);
        tvFourth.setText("");

        layoutFifth.setVisibility(View.VISIBLE);
        tvFifth.setVisibility(View.VISIBLE);
        tvFifth.setText("");

        layoutSexth.setVisibility(View.VISIBLE);
        tvSexth.setVisibility(View.VISIBLE);
        tvSexth.setText("");

        layoutSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setText("");
    }

    private void setMondayVisible(int month) {

        layoutFirst.setVisibility(View.INVISIBLE);

        layoutSecond.setVisibility(View.VISIBLE);
        tvSecond.setVisibility(View.VISIBLE);
        tvSecond.setText(month+"月");

        layoutThree.setVisibility(View.VISIBLE);
        tvThree.setVisibility(View.VISIBLE);
        tvThree.setText("");

        layoutFourth.setVisibility(View.VISIBLE);
        tvFourth.setVisibility(View.VISIBLE);
        tvFourth.setText("");

        layoutFifth.setVisibility(View.VISIBLE);
        tvFifth.setVisibility(View.VISIBLE);
        tvFifth.setText("");

        layoutSexth.setVisibility(View.VISIBLE);
        tvSexth.setVisibility(View.VISIBLE);
        tvSexth.setText("");

        layoutSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setText("");
    }

    private void setSundayVisible(int month){

        layoutFirst.setVisibility(View.VISIBLE);
        tvFirst.setVisibility(View.VISIBLE);
        tvFirst.setText(month+"月");

        layoutSecond.setVisibility(View.VISIBLE);
        tvSecond.setVisibility(View.VISIBLE);
        tvSecond.setText("");

        layoutThree.setVisibility(View.VISIBLE);
        tvThree.setVisibility(View.VISIBLE);
        tvThree.setText("");

        layoutFourth.setVisibility(View.VISIBLE);
        tvFourth.setVisibility(View.VISIBLE);
        tvFourth.setText("");

        layoutFifth.setVisibility(View.VISIBLE);
        tvFifth.setVisibility(View.VISIBLE);
        tvFifth.setText("");

        layoutSexth.setVisibility(View.VISIBLE);
        tvSexth.setVisibility(View.VISIBLE);
        tvSexth.setText("");

        layoutSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setVisibility(View.VISIBLE);
        tvSeventh.setText("");

    }
}
