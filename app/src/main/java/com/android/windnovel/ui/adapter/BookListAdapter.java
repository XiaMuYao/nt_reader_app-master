package com.android.windnovel.ui.adapter;

import android.content.Context;

import com.android.windnovel.model.bean.BookListBean;
import com.android.windnovel.ui.adapter.view.BookListHolder;
import com.android.windnovel.ui.base.adapter.IViewHolder;
import com.android.windnovel.widget.adapter.WholeAdapter;

/**
 * Created by ZTH-003 on 17-5-1.
 */

public class BookListAdapter extends WholeAdapter<BookListBean> {
    public BookListAdapter() {
    }

    public BookListAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<BookListBean> createViewHolder(int viewType) {
        return new BookListHolder();
    }
}
