package com.android.windnovel.ui.adapter.view;

import android.widget.TextView;

import com.android.windnovel.R;
import com.android.windnovel.ui.base.adapter.ViewHolderImpl;

/**
 * Created by ZTH-003 on 17-6-2.
 */

public class KeyWordHolder extends ViewHolderImpl<String>{

    private TextView mTvName;

    @Override
    public void initView() {
        mTvName = findById(R.id.keyword_tv_name);
    }

    @Override
    public void onBind(String data, int pos) {
        mTvName.setText(data);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_keyword;
    }
}
