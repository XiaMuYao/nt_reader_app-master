package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.packages.BookSortPackage;
import com.android.windnovel.model.bean.packages.BookSubSortPackage;
import com.android.windnovel.ui.base.BaseContract;

/**
 * Created by ZTH-003 on 17-4-23.
 */

public interface BookSortContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BookSortPackage sortPackage, BookSubSortPackage subSortPackage);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshSortBean();
    }
}
