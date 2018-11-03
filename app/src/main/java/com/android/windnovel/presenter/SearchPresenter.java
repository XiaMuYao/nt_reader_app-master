package com.android.windnovel.presenter;

import com.android.windnovel.model.remote.RemoteRepository;
import com.android.windnovel.presenter.contract.SearchContract;
import com.android.windnovel.ui.base.RxPresenter;
import com.android.windnovel.utils.LogUtils;
import com.android.windnovel.utils.RxUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by ZTH-003 on 17-6-2.
 */

public class SearchPresenter extends RxPresenter<SearchContract.View>
        implements SearchContract.Presenter{

    @Override
    public void searchHotWord() {
        Disposable disp = RemoteRepository.getInstance()
                .getHotWords()
                .compose(RxUtils::toSimpleSingle)
                .subscribe(
                        bean -> {
                            mView.finishHotWords(bean);
                        },
                        e -> {
                            LogUtils.e(e);
                        }
                );
        addDisposable(disp);
    }

    @Override
    public void searchKeyWord(String query) {
        Disposable disp = RemoteRepository.getInstance()
                .getKeyWords(query)
                .compose(RxUtils::toSimpleSingle)
                .subscribe(
                        bean -> {
                            mView.finishKeyWords(bean);
                        },
                        e -> {
                            LogUtils.e(e);
                        }
                );
        addDisposable(disp);
    }

    @Override
    public void searchBook(String query) {
        Disposable disp = RemoteRepository.getInstance()
                .getSearchBooks(query)
                .compose(RxUtils::toSimpleSingle)
                .subscribe(
                        bean -> {
                            mView.finishBooks(bean);
                        },
                        e -> {
                            LogUtils.e(e);
                            mView.errorBooks();
                        }
                );
        addDisposable(disp);
    }
}
