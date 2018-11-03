package com.android.windnovel.presenter;

import static com.android.windnovel.utils.LogUtils.*;

import com.android.windnovel.model.bean.BookReviewBean;
import com.android.windnovel.model.flag.BookDistillate;
import com.android.windnovel.model.flag.BookSort;
import com.android.windnovel.model.flag.BookType;
import com.android.windnovel.model.local.LocalRepository;
import com.android.windnovel.model.remote.RemoteRepository;
import com.android.windnovel.presenter.contract.DiscReviewContract;
import com.android.windnovel.ui.base.RxPresenter;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZTH-003 on 17-4-21.
 */

public class DiscReviewPresenter extends RxPresenter<DiscReviewContract.View> implements DiscReviewContract.Presenter {
    private static final String TAG = "DiscReviewPresenter";
    private boolean isLocalLoad = false;

    @Override
    public void firstLoading(BookSort sort, BookType bookType,
                             int start, int limited, BookDistillate distillate) {
        //获取数据库中的数据
        Single<List<BookReviewBean>> localObserver = LocalRepository.getInstance()
                .getBookReviews(sort.getDbName(), bookType.getNetName(),
                        start, limited, distillate.getDbName());
        Single<List<BookReviewBean>> remoteObserver = RemoteRepository.getInstance()
                .getBookReviews(sort.getNetName(), bookType.getNetName(),
                        start, limited, distillate.getNetName());

        Single.concat(localObserver,remoteObserver)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (beans) -> {
                            mView.finishRefresh(beans);
                        }
                        ,
                        (e) ->{
                            isLocalLoad = true;
                            mView.complete();
                            mView.showErrorTip();
                            e(e);
                        }
                        ,
                        ()-> {
                            isLocalLoad = false;
                            mView.complete();
                        }
                );
    }

    @Override
    public void refreshBookReview(BookSort sort, BookType bookType,
                                  int start, int limited, BookDistillate distillate) {
        Disposable refreshDispo = RemoteRepository.getInstance()
                .getBookReviews(sort.getNetName(), bookType.getNetName(),
                        start, limited, distillate.getNetName())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (beans)-> {
                            isLocalLoad = false;
                            mView.finishRefresh(beans);
                            mView.complete();
                        }
                        ,
                        (e) ->{
                            mView.complete();
                            mView.showErrorTip();
                            e(e);
                        }
                );
        addDisposable(refreshDispo);
    }

    @Override
    public void loadingBookReview(BookSort sort, BookType bookType,
                                  int start, int limited, BookDistillate distillate) {
        if (isLocalLoad){
            Single<List<BookReviewBean>> single = LocalRepository.getInstance()
                    .getBookReviews(sort.getDbName(), bookType.getNetName(),
                            start, limited, distillate.getDbName());
            loadBookReview(single);
        }

        else{
            //单纯的加载数据
            Single<List<BookReviewBean>> single = RemoteRepository.getInstance()
                    .getBookReviews(sort.getNetName(), bookType.getNetName(),
                            start, limited, distillate.getNetName());
            loadBookReview(single);
        }
    }

    @Override
    public void saveBookReview(List<BookReviewBean> beans) {
        LocalRepository.getInstance()
                .saveBookReviews(beans);
    }

    private void loadBookReview(Single<List<BookReviewBean>> observable){
        Disposable loadDispo =observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (beans) -> {
                            mView.finishLoading(beans);
                        }
                        ,
                        (e) -> {
                            mView.showError();
                            e(e);
                        }
                );
        addDisposable(loadDispo);
    }
}