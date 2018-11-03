package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.BookChapterBean;
import com.android.windnovel.ui.base.BaseContract;
import com.android.windnovel.widget.page.TxtChapter;

import java.util.List;

/**
 * Created by ZTH-003 on 17-5-16.
 */

public interface ReadContract extends BaseContract{
    interface View extends BaseContract.BaseView {
        void showCategory(List<BookChapterBean> bookChapterList);
        void finishChapter();
        void errorChapter();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void loadCategory(String bookId);
        void loadChapter(String bookId,List<TxtChapter> bookChapterList);
    }
}
