package com.android.windnovel.utils;

import android.widget.Toast;

import com.android.windnovel.App;

/**
 * Created by ZTH-003 on 17-5-11.
 */

public class ToastUtils {

    public static void show(String msg){
        Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
