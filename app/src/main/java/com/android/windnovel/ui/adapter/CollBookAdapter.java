package com.android.windnovel.ui.adapter;

import com.android.windnovel.model.bean.CollBookBean;
import com.android.windnovel.ui.adapter.view.CollBookHolder;
import com.android.windnovel.ui.base.adapter.IViewHolder;
import com.android.windnovel.widget.adapter.WholeAdapter;

/**
 * Created by ZTH-003 on 17-5-8.
 */

public class CollBookAdapter extends WholeAdapter<CollBookBean> {

    @Override
    protected IViewHolder<CollBookBean> createViewHolder(int viewType) {
        return new CollBookHolder();
    }

}
