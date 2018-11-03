package com.android.windnovel.ui.adapter;

import com.android.windnovel.ui.adapter.view.KeyWordHolder;
import com.android.windnovel.ui.base.adapter.BaseListAdapter;
import com.android.windnovel.ui.base.adapter.IViewHolder;

/**
 * Created by ZTH-003 on 17-6-2.
 */

public class KeyWordAdapter extends BaseListAdapter<String> {
    @Override
    protected IViewHolder<String> createViewHolder(int viewType) {
        return new KeyWordHolder();
    }
}
