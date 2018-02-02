package com.example.school.adminPage;

import android.app.Application;
import android.content.Context;

/**
 * Created by xiecy on 2017/12/26.
 */

public class AndroidApplication extends Application {

    public static Context MainContext;

    @Override
    public void onCreate() {
        super.onCreate();
        MainContext = getApplicationContext();
    }
}
