package com.android.windnovel.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.android.windnovel.ui.adapter.view.CategoryHolder;
import com.android.windnovel.ui.base.EasyAdapter;
import com.android.windnovel.ui.base.adapter.IViewHolder;
import com.android.windnovel.widget.page.TxtChapter;

/**
 * Created by ZTH-003 on 17-6-5.
 */

public class CategoryAdapter extends EasyAdapter<TxtChapter> {
    private int currentSelected = 0;
    @Override
    protected IViewHolder<TxtChapter> onCreateViewHolder(int viewType) {
        return new CategoryHolder();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        CategoryHolder holder = (CategoryHolder) view.getTag();

        if (position == currentSelected){
            holder.setSelectedChapter();
        }

        return view;
    }

    public void setChapter(int pos){
        currentSelected = pos;
        notifyDataSetChanged();
    }
}
