package com.android.windnovel.ui.adapter;

import com.android.windnovel.model.bean.DownloadTaskBean;
import com.android.windnovel.ui.adapter.view.DownloadHolder;
import com.android.windnovel.ui.base.adapter.BaseListAdapter;
import com.android.windnovel.ui.base.adapter.IViewHolder;

/**
 * Created by ZTH-003 on 17-5-12.
 */

public class DownLoadAdapter extends BaseListAdapter<DownloadTaskBean>{

    @Override
    protected IViewHolder<DownloadTaskBean> createViewHolder(int viewType) {
        return new DownloadHolder();
    }
}
