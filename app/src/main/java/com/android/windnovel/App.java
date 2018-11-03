package com.android.windnovel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.android.windnovel.service.DownloadService;

/**
 * Created by ZTH-003 on 17-4-15.
 */

public class App extends Application {
    private static Context sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        startService(new Intent(getContext(), DownloadService.class));
    }

    public static Context getContext(){
        return sInstance;
    }
}