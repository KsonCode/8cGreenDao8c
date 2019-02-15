package com.example.kson.a8cgreendao.app;

import android.app.Application;

import com.example.kson.a8cgreendao.utils.GreendaoUtils;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        GreendaoUtils.getInstance().initGreenDao(this);//初始化greenndao
    }
}
