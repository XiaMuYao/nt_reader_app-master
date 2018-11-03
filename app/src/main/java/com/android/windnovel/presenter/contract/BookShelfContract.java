package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.CollBookBean;
import com.android.windnovel.ui.base.BaseContract;

import java.util.List;

/**
 * Created by ZTH-003 on 17-5-8.
 */

public interface BookShelfContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(List<CollBookBean> collBookBeans);
        void finishUpdate();
        void showErrorTip(String error);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshCollBooks();
        void createDownloadTask(CollBookBean collBookBean);
        void updateCollBooks(List<CollBookBean> collBookBeans);
        void loadRecommendBooks(String gender);
    }
}
