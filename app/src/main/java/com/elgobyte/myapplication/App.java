package com.elgobyte.myapplication;

import android.content.Context;

public class App extends android.app.Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
