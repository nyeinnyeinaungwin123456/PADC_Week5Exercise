package com.anastatia.testing;

import android.app.Application;
import android.content.Context;

/**
 * Created by Nyein Nyein on 7/18/2016.
 */
public class TestingApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){

        return context;
    }
}
