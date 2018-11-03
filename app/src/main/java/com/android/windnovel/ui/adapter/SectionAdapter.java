package com.android.windnovel.ui.adapter;

import com.android.windnovel.model.bean.SectionBean;
import com.android.windnovel.ui.adapter.view.SectionHolder;
import com.android.windnovel.ui.base.adapter.BaseListAdapter;
import com.android.windnovel.ui.base.adapter.IViewHolder;

/**
 * Created by ZTH-003 on 17-4-16.
 */

public class SectionAdapter extends BaseListAdapter<SectionBean> {
    @Override
    protected IViewHolder<SectionBean> createViewHolder(int viewType) {
        return new SectionHolder();
    }
}
