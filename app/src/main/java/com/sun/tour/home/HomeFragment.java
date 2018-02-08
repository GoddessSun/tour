package com.sun.tour.home;


import android.os.Bundle;
import android.support.v4.view.GravityCompat;
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
import com.sun.tour.OnRecyclerViewItemClick;
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
        //附近
        NearbyAdapter nearbyAdapter = new NearbyAdapter();
        mNearbyRecyclerView.setAdapter(nearbyAdapter);
        nearbyAdapter.setmOnRecyclerViewItemClick(new OnRecyclerViewItemClick() {
            @Override
            public void onItemRecyclerViewClick(int position) {
                ARouter.getInstance().build("/tour/home/hotel_details_activity").navigation();
            }
        });
        //热门
        NearbyAdapter mHotAdapter = new NearbyAdapter();
        mHotRecyclerView.setAdapter(mHotAdapter);
        mHotAdapter.setmOnRecyclerViewItemClick(new OnRecyclerViewItemClick() {
            @Override
            public void onItemRecyclerViewClick(int position) {
                ARouter.getInstance().build("/tour/home/hotel_details_activity").navigation();
            }
        });

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


    @OnClick({R.id.circle_image_view_persion,R.id.text_search,R.id.home_location_tv,
            R.id.home_near_more_tv,R.id.home_near_hot_tv,R.id.home_login_guide_tv,
    R.id.home_use_guide_tv,R.id.home_idea_user_tv})
    public void onPersionClick(View view){

        switch (view.getId()){
            case R.id.circle_image_view_persion:
                if (mDrawerLayout!=null){
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.text_search:
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/search/search_activity")
                        .navigation();
                break;
            case R.id.home_location_tv:
//                final SelectDialogUtils selectDialogUtils = new SelectDialogUtils(getHoldingActivity(),Arrays.asList("相机","从相册中选择","取消"));
//                selectDialogUtils.showDialog();
//                selectDialogUtils.setOnItemDialogClick(new SelectDialogUtils.OnItemDialogClick() {
//                    @Override
//                    public void onClick(int position) {
//                        RxToast.info("点击："+position);
//                        selectDialogUtils.dismissDialog();
//                    }
//                });
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/city/choicecity_activity")
                        .navigation();
                break;
            case R.id.home_near_more_tv:
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/home/near/near_activity")
                        .navigation();
                break;
            case R.id.home_near_hot_tv:
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/home/near/near_activity")
                        .navigation();
                break;
            case R.id.home_login_guide_tv:
                Bundle loginBundle = new Bundle();
                loginBundle.putInt("type",Constant.GUIDE.LOGIN_GUIDE);
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/login/guide/loginguide_activity")
                        .with(loginBundle)
                        .navigation();
                break;
            case R.id.home_use_guide_tv:
                Bundle useBundle = new Bundle();
                useBundle.putInt("type",Constant.GUIDE.USE_GUIDE);
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/login/guide/loginguide_activity")
                        .with(useBundle)
                        .navigation();
                break;
            case R.id.home_idea_user_tv:
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/tourguide/ideauser_activity")
                        .navigation();
                break;
        }

    }


}
