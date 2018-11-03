package com.android.windnovel.event;

import com.android.windnovel.model.bean.CollBookBean;

/**
 * Created by ZTH-003 on 18-3-1.
 */

public class DeleteTaskEvent {
    public CollBookBean collBook;

    public DeleteTaskEvent(CollBookBean collBook){
        this.collBook = collBook;
    }
}
