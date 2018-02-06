package com.sun.tour.message.chat;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.imageselector.utils.ImageSelectorUtils;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 聊天界面
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/message/chat/chat_activity")
public class ChatActivity extends BaseActivity implements ChatContract.View {

    @BindView(R.id.chat_bottom_message_layout)
    LinearLayout bottomLayout;
    @BindView(R.id.chat_recyclerview)
    RecyclerView rv;
    @BindView(R.id.chat_list_smartrefreshlayout)
    SmartRefreshLayout refreshLayout;
    private ChatContract.Presenter presenter;
    private List<String> data = new ArrayList<>();
    private ChatAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {
        ChatPresenter chatPresenter = new ChatPresenter();
        chatPresenter.bindView(this);

        mAdapter = new ChatAdapter(this,data);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(mAdapter);
        for (int i = 0; i < 40; i++) {
            data.add("测试-----"+i);
        }
        mAdapter.notifyDataSetChanged();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                List<String> d = new ArrayList<>();
                d.addAll(data);
                data.clear();
                for (int i = 0; i < 20; i++) {
                    data.add("测试-----"+i);
                }
                data.addAll(d);
                mAdapter.notifyDataSetChanged();
                refreshlayout.finishRefresh(2000);
            }
        });
    }

    @Override
    public void bindPresenter(ChatContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @OnClick({R.id.chat_bottom_image_iv})
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.chat_bottom_image_iv:
                ImageSelectorUtils.openPhotoAndClip(this,0);
                break;
        }
    }
}
