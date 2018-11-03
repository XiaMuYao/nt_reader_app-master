package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.SortBookBean;
import com.android.windnovel.model.flag.BookSortListType;
import com.android.windnovel.ui.base.BaseContract;

import java.util.List;

/**
 * Created by ZTH-003 on 17-5-3.
 */

public interface BookSortListContract {
    interface View extends BaseContract.BaseView{
        void finishRefresh(List<SortBookBean> beans);
        void finishLoad(List<SortBookBean> beans);
        void showLoadError();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshSortBook(String gender, BookSortListType type, String major, String minor, int start, int limit);
        void loadSortBook(String gender,BookSortListType type,String major,String minor,int start,int limit);
    }
}
