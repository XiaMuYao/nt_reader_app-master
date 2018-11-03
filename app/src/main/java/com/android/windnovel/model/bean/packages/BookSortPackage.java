package com.android.windnovel.model.bean.packages;

import com.android.windnovel.model.bean.BaseBean;
import com.android.windnovel.model.bean.BookSortBean;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-23.
 */

public class BookSortPackage extends BaseBean {

    private List<BookSortBean> male;
    private List<BookSortBean> female;

    public List<BookSortBean> getMale() {
        return male;
    }

    public void setMale(List<BookSortBean> male) {
        this.male = male;
    }

    public List<BookSortBean> getFemale() {
        return female;
    }

    public void setFemale(List<BookSortBean> female) {
        this.female = female;
    }
}
