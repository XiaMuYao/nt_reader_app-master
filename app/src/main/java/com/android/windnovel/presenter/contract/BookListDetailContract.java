package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.BookListDetailBean;
import com.android.windnovel.ui.base.BaseContract;

/**
 * Created by ZTH-003 on 17-5-1.
 */

public interface BookListDetailContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BookListDetailBean bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshBookListDetail(String detailId);
    }
}
