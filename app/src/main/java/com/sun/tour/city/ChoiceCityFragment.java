package com.sun.tour.city;

import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.sun.tour.R;
import com.sun.tour.base.BaseFragment;
import com.sun.tour.view.ClearEditText;
import com.sun.tour.view.SideBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * 选择城市
 *
 * Created by hanyg on 2018/1/16.
 */

public class ChoiceCityFragment extends BaseFragment {

    @BindView(R.id.choice_city_search_et)
    ClearEditText etSearch;
    @BindView(R.id.choice_city_lv)
    ListView lv;
    @BindView(R.id.choice_city_sv)
    SideBarView sv;
    private TextView tvNowLocation;
    private GridView nowGV;
    private GridView hotGV;

    private List<String> nowData = new ArrayList<>();
    private List<String> hotData = new ArrayList<>();
    private List<ChoiceCityModel> data = new ArrayList<>();

    private ChoiceCityHeaderAdapter nowAdapter;
    private ChoiceCityHeaderAdapter hotAdapter;
    private ChoiceCityAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_choice_city;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {
        init();
    }

    @OnClick({R.id.choice_city_cancel})
    public void onClick(View v){

    }

    private void init() {

        View view = getLayoutInflater().inflate(R.layout.item_choice_city_header,null);
        tvNowLocation = view.findViewById(R.id.choice_city_header_now_location_tv);
        nowGV = view.findViewById(R.id.choice_city_header_now_gv);
        hotGV = view.findViewById(R.id.choice_city_hot_gv);
        nowAdapter = new ChoiceCityHeaderAdapter(getActivity(),nowData);
        hotAdapter = new ChoiceCityHeaderAdapter(getActivity(),hotData);
        nowGV.setAdapter(nowAdapter);
        hotGV.setAdapter(hotAdapter);
        lv.addHeaderView(view);

        mAdapter = new ChoiceCityAdapter(getActivity(),data);
        lv.setAdapter(mAdapter);

        sv.setOnTouchLetterChangeListener(new SideBarView.OnTouchLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {

                if (TextUtils.equals("热门",letter) || TextUtils.equals("当前",letter)){

                    lv.setSelection(-1);
                }else{
                    for (int i = 0; i < data.size(); i++) {

                        ChoiceCityModel model = data.get(i);
                        if (TextUtils.equals(letter,model.getFirst())) {
                            lv.setSelection(i);
                            return;
                        }
                    }
                }

            }
        });
        nowData.add("北京");

        for (int i = 0; i < 10; i++) {
            hotData.add("测试--"+i);
        }

        char a = 'A';
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 10; j++) {

                ChoiceCityModel model = new ChoiceCityModel();
                if (j == 0){
                    model.setShow(true);
                    model.setFirst(""+a);
                    a += 1;
                }
                model.setName("测试--"+j);
                data.add(model);
            }
        }

        nowAdapter.notifyDataSetChanged();
        hotAdapter.notifyDataSetChanged();
        mAdapter.notifyDataSetChanged();
    }
}
