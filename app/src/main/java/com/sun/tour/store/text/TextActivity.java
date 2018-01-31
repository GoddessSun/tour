package com.sun.tour.store.text;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = Constant.ACTVIITY_ROUTE + "/store/text/text_activity")
public class TextActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    @OnClick({R.id.store_edit_text_back_iv, R.id.store_edit_text_save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_edit_text_back_iv:
                finish();
                break;
            case R.id.store_edit_text_save_tv:
                break;
        }
    }
}
