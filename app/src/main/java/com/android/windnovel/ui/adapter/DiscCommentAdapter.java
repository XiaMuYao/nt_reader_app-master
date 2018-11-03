package com.android.windnovel.ui.adapter;

import android.content.Context;

import com.android.windnovel.model.bean.BookCommentBean;
import com.android.windnovel.ui.adapter.view.DiscCommentHolder;
import com.android.windnovel.ui.base.adapter.IViewHolder;
import com.android.windnovel.widget.adapter.WholeAdapter;

/**
 * Created by ZTH-003 on 17-4-20.
 */

public class DiscCommentAdapter extends WholeAdapter<BookCommentBean> {

    public DiscCommentAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<BookCommentBean> createViewHolder(int viewType) {
        return new DiscCommentHolder();
    }
}
