package com.android.windnovel.ui.adapter;

import android.content.Context;

import com.android.windnovel.model.bean.CommentBean;
import com.android.windnovel.ui.adapter.view.CommentHolder;
import com.android.windnovel.ui.base.adapter.IViewHolder;
import com.android.windnovel.widget.adapter.WholeAdapter;

/**
 * Created by ZTH-003 on 17-4-29.
 */

public class CommentAdapter extends WholeAdapter<CommentBean> {

    public CommentAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<CommentBean> createViewHolder(int viewType) {
        return new CommentHolder(false);
    }
}
