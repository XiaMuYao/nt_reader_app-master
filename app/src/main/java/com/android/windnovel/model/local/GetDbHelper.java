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

import io.reactivex.Single;

/**
 * Created by ZTH-003 on 17-4-28.
 */

public interface GetDbHelper {
    Single<List<BookCommentBean>> getBookComments(String block, String sort, int start, int limited, String distillate);
    Single<List<BookHelpsBean>> getBookHelps(String sort, int start, int limited, String distillate);
    Single<List<BookReviewBean>> getBookReviews(String sort, String bookType, int start, int limited, String distillate);
    BookSortPackage getBookSortPackage();
    BillboardPackage getBillboardPackage();

    AuthorBean getAuthor(String id);
    ReviewBookBean getReviewBook(String id);
    BookHelpfulBean getBookHelpful(String id);

    /******************************/
    List<DownloadTaskBean> getDownloadTaskList();
}
