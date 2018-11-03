package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.BookListBean;
import com.android.windnovel.model.flag.BookListType;
import com.android.windnovel.ui.base.BaseContract;

import java.util.List;

/**
 * Created by ZTH-003 on 17-5-1.
 */

public interface BookListContract {
    interface View extends BaseContract.BaseView{
        void finishRefresh(List<BookListBean> beans);
        void finishLoading(List<BookListBean> beans);
        void showLoadError();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshBookList(BookListType type, String tag,int start, int limited);
        void loadBookList(BookListType type, String tag,int start, int limited);
    }
}
