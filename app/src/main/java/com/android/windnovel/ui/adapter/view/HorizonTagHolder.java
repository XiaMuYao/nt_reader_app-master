package com.android.windnovel.ui.adapter.view;

import android.widget.TextView;

import com.android.windnovel.R;
import com.android.windnovel.ui.base.adapter.ViewHolderImpl;

/**
 * Created by ZTH-003 on 17-5-2.
 */

public class HorizonTagHolder extends ViewHolderImpl<String> {

    private TextView mTvName;

    @Override
    public void initView() {
        mTvName = findById(R.id.horizon_tag_tv_name);
    }

    @Override
    public void onBind(String value, int pos) {
        mTvName.setText(value);
        mTvName.setTextColor(getContext().getResources().getColor(R.color.nb_text_common_h2));
    }

    public void setSelectedTag(){
        mTvName.setTextColor(getContext().getResources().getColor(R.color.light_red));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_horizon_tag;
    }
}