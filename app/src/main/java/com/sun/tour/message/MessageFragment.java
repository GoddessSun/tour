package com.sun.tour.message;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.sun.tour.R;
import com.sun.tour.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MessageFragment extends BaseFragment implements MessageContract.View{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @BindView(R.id.message_smart_srf)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.message_list_rv)
    RecyclerView rv;
    @BindView(R.id.message_empty_layout)
    LinearLayout emptyLayout;

    private List<String> data = new ArrayList<>();
    private MessageContract.Presenter presenter;
    private MessageAdapter mAdapter;

    public MessageFragment() {
        // Required empty public constructor
    }

    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {

        init();
    }

    private void init() {
        MessagePresenter messagePresenter = new MessagePresenter();
        messagePresenter.bindView(this);
        mAdapter = new MessageAdapter(getActivity(),data);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(mAdapter);

        for (int i = 0; i < 20; i++) {
            data.add("测试");
        }
        mAdapter.notifyDataSetChanged();
        showEmptyStatus();
        setListener();
    }

    private void setListener() {

        refreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                refreshLayout.finishLoadmore(1000);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                refreshLayout.finishRefresh(1000);
            }
        });
    }


    @Override
    public void bindPresenter(MessageContract.Presenter presenter) {

        this.presenter = presenter;
    }

    private void showEmptyStatus(){

        refreshLayout.setVisibility(View.GONE);
        emptyLayout.setVisibility(View.GONE);
        if (data.isEmpty()) {
            emptyLayout.setVisibility(View.VISIBLE);
        }else{
            refreshLayout.setVisibility(View.VISIBLE);
        }
    }
}
