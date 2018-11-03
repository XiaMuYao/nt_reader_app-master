package com.android.windnovel.ui.adapter;

import com.android.windnovel.model.bean.HotCommentBean;
import com.android.windnovel.ui.adapter.view.HotCommentHolder;
import com.android.windnovel.ui.base.adapter.BaseListAdapter;
import com.android.windnovel.ui.base.adapter.IViewHolder;

/**
 * Created by ZTH-003 on 17-5-4.
 */

public class HotCommentAdapter extends BaseListAdapter<HotCommentBean>{
    @Override
    protected IViewHolder<HotCommentBean> createViewHolder(int viewType) {
        return new HotCommentHolder();
    }
}
