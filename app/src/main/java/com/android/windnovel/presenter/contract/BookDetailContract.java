package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.BookDetailBean;
import com.android.windnovel.model.bean.BookListBean;
import com.android.windnovel.model.bean.CollBookBean;
import com.android.windnovel.model.bean.HotCommentBean;
import com.android.windnovel.ui.base.BaseContract;

import java.util.List;

/**
 * Created by ZTH-003 on 17-5-4.
 */

public interface BookDetailContract {
    interface View extends BaseContract.BaseView{
        void finishRefresh(BookDetailBean bean);
        void finishHotComment(List<HotCommentBean> beans);
        void finishRecommendBookList(List<BookListBean> beans);

        void waitToBookShelf();
        void errorToBookShelf();
        void succeedToBookShelf();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshBookDetail(String bookId);
        //添加到书架上
        void addToBookShelf(CollBookBean collBook);
    }
}
