package com.example.recu_m3_m9;

import android.app.Application;

import com.example.recu_m3_m9.Data.Repository;

public class DirectoryApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Repository.get(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
