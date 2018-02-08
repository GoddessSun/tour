package com.sun.tour.tourguide;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.tour.R;
import com.sun.tour.base.BaseActivity;
import com.sun.tour.utils.Constant;

import butterknife.OnClick;

/**
 * 意见反馈
 */
@Route(path = Constant.ACTVIITY_ROUTE + "/tourguide/ideauser_activity")
public class IdeaUserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_user);
        init();
    }

    @Override
    public boolean useOwnContentView() {
        return true;
    }

    private void init() {

    }

    @OnClick({R.id.idea_user_cancel_iv, R.id.idea_user_save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idea_user_cancel_iv:
                finish();
                break;
            case R.id.idea_user_save_tv:
                break;
        }
    }
}
