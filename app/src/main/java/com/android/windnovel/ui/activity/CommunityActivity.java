package com.android.windnovel.ui.activity;

import android.support.v7.widget.Toolbar;

import com.android.windnovel.R;
import com.android.windnovel.ui.base.BaseActivity;

/**
 * Created by ZTH-003 on 17-5-26.
 */

public class CommunityActivity extends BaseActivity{

    @Override
    protected int getContentId() {
        return R.layout.activity_community;
    }

    @Override
    protected void setUpToolbar(Toolbar toolbar) {
        super.setUpToolbar(toolbar);
        getSupportActionBar().setTitle("社区");
    }
}
