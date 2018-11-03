package com.android.windnovel.presenter;

import com.android.windnovel.model.remote.RemoteRepository;
import com.android.windnovel.presenter.contract.BillBookContract;
import com.android.windnovel.ui.base.RxPresenter;
import com.android.windnovel.utils.LogUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZTH-003 on 17-5-3.
 */

public class BillBookPresenter extends RxPresenter<BillBookContract.View>
        implements BillBookContract.Presenter {
    private static final String TAG = "BillBookPresenter";
    @Override
    public void refreshBookBrief(String billId) {
        Disposable remoteDisp = RemoteRepository.getInstance()
                .getBillBooks(billId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (beans)-> {
                            mView.finishRefresh(beans);
                            mView.complete();
                        }
                        ,
                        (e) ->{
                            mView.showError();
                            LogUtils.e(e);
                        }
                );
        addDisposable(remoteDisp);
    }
}
