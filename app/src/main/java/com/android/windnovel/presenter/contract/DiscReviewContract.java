package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.BookReviewBean;
import com.android.windnovel.model.flag.BookDistillate;
import com.android.windnovel.model.flag.BookSort;
import com.android.windnovel.model.flag.BookType;
import com.android.windnovel.ui.base.BaseContract;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-21.
 */

public interface DiscReviewContract {
    interface View extends BaseContract.BaseView {
        void finishRefresh(List<BookReviewBean> beans);
        void finishLoading(List<BookReviewBean> beans);
        void showErrorTip();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void firstLoading(BookSort sort, BookType bookType, int start, int limited, BookDistillate distillate);
        void refreshBookReview(BookSort sort, BookType bookType, int start, int limited, BookDistillate distillate);
        void loadingBookReview(BookSort sort, BookType bookType, int start, int limited, BookDistillate distillate);
        void saveBookReview(List<BookReviewBean> beans);
    }
}
