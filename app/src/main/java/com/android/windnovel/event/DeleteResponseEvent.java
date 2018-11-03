package com.android.windnovel.event;

import com.android.windnovel.model.bean.CollBookBean;

/**
 * Created by ZTH-003 on 18-3-1.
 */

public class DeleteResponseEvent {
    public boolean isDelete;
    public CollBookBean collBook;
    public DeleteResponseEvent(boolean isDelete,CollBookBean collBook){
        this.isDelete = isDelete;
        this.collBook = collBook;
    }
}
