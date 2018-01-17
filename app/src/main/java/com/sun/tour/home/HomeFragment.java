package com.sun.tour.home;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sun.tour.MainActivity;
import com.sun.tour.R;
import com.sun.tour.base.BaseFragment;
import com.sun.tour.home.adapter.NearbyAdapter;
import com.sun.tour.utils.Constant;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.refresh_layout_home)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.scrollView_home)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.recyclerview_nearby_home)
    RecyclerView mNearbyRecyclerView;
    @BindView(R.id.recyclerview_hot_home)
    RecyclerView mHotRecyclerView;
    @BindView(R.id.circle_image_view_persion)
    CircleImageView mCircleImageView;
    @BindView(R.id.banner_home)
    BGABanner mBGABanner;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String url01 = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4054140830,4230019944&fm=11&gp=0.jpg";
    private String url02 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1647017159,369299238&fm=27&gp=0.jpg";
    private String url03 = "http://img4.imgtn.bdimg.com/it/u=3537253734,3552658244&fm=27&gp=0.jpg";

    private String mParam1;
    private String mParam2;
    private DrawerLayout mDrawerLayout;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void initViews(View rootView) {
        MainActivity mainActivity = (MainActivity) getHoldingActivity();
        mDrawerLayout = mainActivity.getPersionDrawerLayout();
        mSmartRefreshLayout.setEnableLoadmore(false);
        LinearLayoutManager mNearbyLinearLayoutManager = new LinearLayoutManager(getHoldingActivity());
        mNearbyLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mNearbyRecyclerView.setLayoutManager(mNearbyLinearLayoutManager);

        LinearLayoutManager mHotLinearLayoutManager = new LinearLayoutManager(getHoldingActivity());
        mHotLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHotRecyclerView.setLayoutManager(mHotLinearLayoutManager);

        NearbyAdapter nearbyAdapter = new NearbyAdapter();
        mNearbyRecyclerView.setAdapter(nearbyAdapter);

        mHotRecyclerView.setAdapter(nearbyAdapter);

        initBanner();
    }
    //轮播
    private void initBanner() {
        mBGABanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(getHoldingActivity())
                        .load(model)
                        .apply(new RequestOptions().placeholder(R.drawable.shape_imge_placeholder).error(R.drawable.shape_imge_placeholder).dontAnimate().centerCrop())
                        .into(itemView);
            }
        });
//        mBGABanner.setAutoPlayAble(false);
        mBGABanner.setData(Arrays.asList(url01,url02,url03), Arrays.asList("", "", ""));
    }


    @OnClick(R.id.circle_image_view_persion)
    public void onPersionClick(){
//        if (mDrawerLayout!=null){
//            mDrawerLayout.openDrawer(GravityCompat.START);
//        }
        ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/search/search_activity")
                .navigation();
    }


}
