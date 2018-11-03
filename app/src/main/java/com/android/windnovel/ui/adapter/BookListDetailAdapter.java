package com.android.windnovel.ui.adapter;

import android.content.Context;

import com.android.windnovel.model.bean.BookListDetailBean;
import com.android.windnovel.ui.adapter.view.BookListInfoHolder;
import com.android.windnovel.ui.base.adapter.IViewHolder;
import com.android.windnovel.widget.adapter.WholeAdapter;

/**
 * Created by ZTH-003 on 17-5-2.
 */

public class BookListDetailAdapter extends WholeAdapter<BookListDetailBean.BooksBean.BookBean> {
    public BookListDetailAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<BookListDetailBean.BooksBean.BookBean> createViewHolder(int viewType) {
        return new BookListInfoHolder();
    }
}
