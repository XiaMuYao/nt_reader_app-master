package com.android.windnovel.presenter;

import com.android.windnovel.model.remote.RemoteRepository;
import com.android.windnovel.presenter.contract.BookListDetailContract;
import com.android.windnovel.ui.base.RxPresenter;
import com.android.windnovel.utils.LogUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZTH-003 on 17-5-2.
 */

public class BookListDetailPresenter extends RxPresenter<BookListDetailContract.View> implements BookListDetailContract.Presenter {
    @Override
    public void refreshBookListDetail(String detailId) {
        Disposable refreshDispo = RemoteRepository.getInstance()
                .getBookListDetail(detailId)
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
        addDisposable(refreshDispo);
    }
}
