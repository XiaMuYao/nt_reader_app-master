package com.android.windnovel.model.bean.packages;

import com.android.windnovel.model.bean.BaseBean;
import com.android.windnovel.model.bean.BookReviewBean;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-21.
 */

public class BookReviewPackage extends BaseBean {

    private List<BookReviewBean> reviews;

    public List<BookReviewBean> getReviews() {
        return reviews;
    }

    public void setReviews(List<BookReviewBean> reviews) {
        this.reviews = reviews;
    }
}
