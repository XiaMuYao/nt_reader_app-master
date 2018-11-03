package com.android.windnovel.model.bean.packages;

import com.android.windnovel.model.bean.BaseBean;
import com.android.windnovel.model.bean.BookHelpsBean;

import java.util.List;

/**
 * Created by ZTH-003 on 17-4-20.
 */

public class BookHelpsPackage extends BaseBean {

    private List<BookHelpsBean> helps;

    public List<BookHelpsBean> getHelps() {
        return helps;
    }

    public void setHelps(List<BookHelpsBean> helps) {
        this.helps = helps;
    }

}
