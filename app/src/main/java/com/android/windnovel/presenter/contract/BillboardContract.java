package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.packages.BillboardPackage;
import com.android.windnovel.ui.base.BaseContract;

/**
 * Created by ZTH-003 on 17-4-23.
 */

public interface BillboardContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BillboardPackage beans);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void loadBillboardList();
    }
}
