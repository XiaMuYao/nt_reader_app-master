package com.android.windnovel.model.bean.packages;

import com.android.windnovel.model.bean.BaseBean;
import com.android.windnovel.model.bean.CollBookBean;

import java.util.List;

/**
 * Created by ZTH-003 on 17-5-8.
 */

public class RecommendBookPackage extends BaseBean {

    private List<CollBookBean> books;

    public List<CollBookBean> getBooks() {
        return books;
    }

    public void setBooks(List<CollBookBean> books) {
        this.books = books;
    }
}
