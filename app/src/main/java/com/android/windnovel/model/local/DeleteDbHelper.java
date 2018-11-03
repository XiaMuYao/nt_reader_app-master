package com.android.windnovel.model.local;

import com.android.windnovel.model.bean.AuthorBean;
import com.android.windnovel.model.bean.ReviewBookBean;
import com.android.windnovel.model.bean.BookCommentBean;
import com.android.windnovel.model.bean.BookHelpfulBean;
import com.android.windnovel.model.bean.BookHelpsBean;
import com.android.windnovel.model.bean.BookReviewBean;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-28.
 */

public interface DeleteDbHelper {
    void deleteBookComments(List<BookCommentBean> beans);
    void deleteBookReviews(List<BookReviewBean> beans);
    void deleteBookHelps(List<BookHelpsBean> beans);
    void deleteAuthors(List<AuthorBean> beans);
    void deleteBooks(List<ReviewBookBean> beans);
    void deleteBookHelpful(List<BookHelpfulBean> beans);
    void deleteAll();
}
