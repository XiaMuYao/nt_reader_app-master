package com.android.windnovel.model.local;

import com.android.windnovel.model.bean.AuthorBean;
import com.android.windnovel.model.bean.DownloadTaskBean;
import com.android.windnovel.model.bean.packages.BillboardPackage;
import com.android.windnovel.model.bean.ReviewBookBean;
import com.android.windnovel.model.bean.BookCommentBean;
import com.android.windnovel.model.bean.BookHelpfulBean;
import com.android.windnovel.model.bean.BookHelpsBean;
import com.android.windnovel.model.bean.BookReviewBean;
import com.android.windnovel.model.bean.packages.BookSortPackage;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-28.
 */

public interface SaveDbHelper {
    void saveBookComments(List<BookCommentBean> beans);
    void saveBookHelps(List<BookHelpsBean> beans);
    void saveBookReviews(List<BookReviewBean> beans);
    void saveAuthors(List<AuthorBean> beans);
    void saveBooks(List<ReviewBookBean> beans);
    void saveBookHelpfuls(List<BookHelpfulBean> beans);

    void saveBookSortPackage(BookSortPackage bean);
    void saveBillboardPackage(BillboardPackage bean);
    /*************DownloadTask*********************/
    void saveDownloadTask(DownloadTaskBean bean);
}
