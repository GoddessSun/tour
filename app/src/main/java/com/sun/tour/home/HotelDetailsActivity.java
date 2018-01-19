package com.sun.tour.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;

import java.util.Arrays;

import butterknife.BindView;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        initBanner();
    }

    //轮播
    private void initBanner() {
        mBGABanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(HotelDetailsActivity.this)
                        .load(model)
                        .apply(new RequestOptions().placeholder(R.drawable.shape_imge_placeholder).error(R.drawable.shape_imge_placeholder).dontAnimate().centerCrop())
                        .into(itemView);
            }
        });
        mBGABanner.setAutoPlayAble(false);
        mBGABanner.setData(Arrays.asList(url01,url02,url03,url04,url05), Arrays.asList("", "", "","",""));
    }
}
