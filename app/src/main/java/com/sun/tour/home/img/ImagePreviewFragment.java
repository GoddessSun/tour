package com.sun.tour.home.img;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.sun.tour.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hanyg on 2018/2/6.
 */

public class ImagePreviewFragment extends Fragment {

    @BindView(R.id.image_preview_pv)
    PhotoView pv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_image_preview, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    private void init() {
        Bundle bundle = getArguments();
        String path = bundle.getString("path");

        Glide.with(getActivity())
                .load(path)
                .into(pv);
    }

    @OnClick(R.id.image_preview_pv)
    public void onClick() {

        getActivity().finish();
    }
}
