package com.sun.tour.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amap.api.maps.model.LatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

@Route(path = "/tour/home/hotel_details_activity")
public class HotelDetailsActivity extends BaseActivity {

    @BindView(R.id.banner_hotel_details)
    BGABanner mBGABanner;

    private String url01 = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4054140830,4230019944&fm=11&gp=0.jpg";
    private String url02 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1647017159,369299238&fm=27&gp=0.jpg";
    private String url03 = "http://img4.imgtn.bdimg.com/it/u=3537253734,3552658244&fm=27&gp=0.jpg";
    private String url04 = "https://ss0.bdstatic.com/6ONWsjip0QIZ8tyhnq/it/u=3545401083,2251952841&fm=77&w_h=121_75&cs=2008984878,1171842780";
    private String url05 = "https://ss0.bdstatic.com/6ONWsjip0QIZ8tyhnq/it/u=1618097094,4154452434&fm=77&w_h=121_75&cs=423647557,799948659";
    private ArrayList<String> arrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        initBanner();
    }

    //轮播
    private void initBanner() {
        arrs = new ArrayList<>();
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015555&di=86359d6c9080ca24ce04ce885cbe5429&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01b2295568a994000001271604da4f.jpg%40900w_1l_2o_100sh.jpg");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015555&di=79905db8a342a0bf2e0de24731bce6d8&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201406%2F27%2F20140627094458_GYx38.jpeg");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015555&di=29a129389fae7005419b900c77df5e0b&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201510%2F26%2F20151026221548_k3VKS.jpeg");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015555&di=383b6dfb759017e94bcbd2328ea403e9&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201508%2F30%2F20150830100800_yeGMd.thumb.700_0.jpeg");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015554&di=2051ad06058ab44dcec54615d84547ad&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0149eb5907e5aca801214550866692.png%401280w_1l_2o_100sh.png");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015554&di=f607df7fb7147d5182e9857a320ebbf1&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201507%2F14%2F20150714124309_KmWjs.jpeg");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015554&di=76eecac8c54d10c81469825a41b9ed7d&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01a5d557f52cb1a84a0d304ff18182.jpg%401280w_1l_2o_100sh.jpg");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980188654&di=1d144d4cc0e11122383eab8366c74377&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D889801630%2C4036685113%26fm%3D214%26gp%3D0.jpg");
        arrs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517980015554&di=312a27cfa632f861b6edb5c4b88ca4be&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201510%2F25%2F20151025233655_nrPax.jpeg");

        mBGABanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(HotelDetailsActivity.this)
                        .load(model)
                        .apply(new RequestOptions().placeholder(R.drawable.shape_imge_placeholder).error(R.drawable.shape_imge_placeholder).dontAnimate().centerCrop())
                        .into(itemView);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ArrayList<String> arr = new ArrayList<>();
                        for (int i = 0; i < arrs.size(); i++) {
                            arr.add(arrs.get(i));
                        }
                        Bundle bun = new Bundle();
                        bun.putStringArrayList("selected", arr);
                        bun.putInt("position",mBGABanner.getCurrentItem());
                        ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/home/img/imagepreview_activity")
                                .with(bun)
                                .navigation();
                    }
                });
            }
        });
        mBGABanner.setAutoPlayAble(false);
//        arrs = Arrays.asList(url01, url02, url03, url04, url05);
        mBGABanner.setData(arrs, Arrays.asList("", "", "","",""));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.hotel_detail_subscribe_btn,R.id.text_see_map_hotel_details,R.id.hotel_detail_request_btn})
    public void onClick(View view){

        switch (view.getId()) {
            case R.id.hotel_detail_subscribe_btn:
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE+"/home/subscribe/subscribe_activity")
                    .navigation(this);

                break;
            case R.id.text_see_map_hotel_details:
                LatLng latLng = new LatLng(39.906901,116.397972);
                Bundle bundle = new Bundle();
                bundle.putParcelable("latlng",latLng);
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/home/map/map_activity")
                        .with(bundle)
                        .navigation(this);
                break;
            case R.id.hotel_detail_request_btn:
                ARouter.getInstance().build(Constant.ACTVIITY_ROUTE + "/message/chat/chat_activity").navigation();
                break;
        }
    }
}
