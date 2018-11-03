package com.android.windnovel.model.bean.packages;

import com.android.windnovel.model.bean.BaseBean;

import java.util.List;

/**
 * Created by ZTH-003 on 17-6-2.
 */

public class HotWordPackage extends BaseBean {


    private List<String> hotWords;

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }
}
