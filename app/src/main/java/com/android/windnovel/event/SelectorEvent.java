package com.android.windnovel.event;

import com.android.windnovel.model.flag.BookDistillate;
import com.android.windnovel.model.flag.BookSort;
import com.android.windnovel.model.flag.BookType;
import com.android.windnovel.utils.Constant;

/**
 * Created by ZTH-003 on 18-3-1.
 */

public class SelectorEvent {

    public BookDistillate distillate;

    public BookType type;

    public BookSort sort;

    public SelectorEvent(BookDistillate distillate,
                         BookType type,
                         BookSort sort) {
        this.distillate = distillate;
        this.type = type;
        this.sort = sort;
    }
}
