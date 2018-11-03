package com.android.windnovel.ui.adapter;

import com.android.windnovel.model.bean.BookSortBean;
import com.android.windnovel.ui.adapter.view.BookSortHolder;
import com.android.windnovel.ui.base.adapter.BaseListAdapter;
import com.android.windnovel.ui.base.adapter.IViewHolder;

/**
 * Created by ZTH-003 on 17-4-23.
 */

public class BookSortAdapter extends BaseListAdapter<BookSortBean>{

    @Override
    protected IViewHolder<BookSortBean> createViewHolder(int viewType) {
        return new BookSortHolder();
    }
}
