package com.sun.tour.home.map;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.BindView;

@Route(path = Constant.ACTVIITY_ROUTE + "/home/map/map_activity")
public class MapActivity extends BaseActivity {

    @BindView(R.id.map_view)
    MapView mapView;
    private AMap map;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mapView.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setTopTitle("地图");
        getBundleData();
        if (map == null){
            map = mapView.getMap();
        }
        if (latLng != null){
            Marker marker = map.addMarker(new MarkerOptions().position(latLng).title("北京").snippet("DefaultMarker"));
        }

    }

    private void getBundleData() {
        Bundle bundle = getIntent().getExtras();
        latLng = bundle.getParcelable("latlng");
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapView != null) {
            mapView.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (mapView != null) {
            mapView.onSaveInstanceState(outState);
        }
    }
}
