package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.BookHelpsBean;
import com.android.windnovel.model.flag.BookDistillate;
import com.android.windnovel.model.flag.BookSort;
import com.android.windnovel.ui.base.BaseContract;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-21.
 */

public interface DiscHelpsContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(List<BookHelpsBean> beans);
        void finishLoading(List<BookHelpsBean> beans);
        void showErrorTip();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void firstLoading(BookSort sort, int start, int limited, BookDistillate distillate);
        void refreshBookHelps(BookSort sort, int start, int limited, BookDistillate distillate);
        void loadingBookHelps(BookSort sort, int start,int limited,BookDistillate distillate);
        void saveBookHelps(List<BookHelpsBean> beans);
    }
}
