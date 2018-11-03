package com.android.windnovel.presenter.contract;

import com.android.windnovel.model.bean.BookCommentBean;
import com.android.windnovel.model.flag.BookDistillate;
import com.android.windnovel.model.flag.BookSort;
import com.android.windnovel.model.flag.CommunityType;
import com.android.windnovel.ui.base.BaseContract;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-20.
 */

public interface DiscCommentContact {

    interface View extends BaseContract.BaseView{
        void finishRefresh(List<BookCommentBean> beans);
        void finishLoading(List<BookCommentBean> beans);
        void showErrorTip();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void firstLoading(CommunityType block, BookSort sort, int start, int limited, BookDistillate distillate);
        void refreshComment(CommunityType block, BookSort sort, int start, int limited, BookDistillate distillate);
        void loadingComment(CommunityType block, BookSort sort, int start, int limited, BookDistillate distillate);
        void saveComment(List<BookCommentBean> beans);
    }
}
