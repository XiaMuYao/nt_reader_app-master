package com.android.windnovel.model.bean.packages;

import com.android.windnovel.model.bean.BaseBean;
import com.android.windnovel.model.bean.HotCommentBean;

import java.util.List;

/**
 * Created by ZTH-003 on 17-5-4.
 */

public class HotCommentPackage extends BaseBean {

    private List<HotCommentBean> reviews;

    public List<HotCommentBean> getReviews() {
        return reviews;
    }

    public void setReviews(List<HotCommentBean> reviews) {
        this.reviews = reviews;
    }
}
