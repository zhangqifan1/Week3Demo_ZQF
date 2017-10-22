package com.bawei.week3demo_zqf.App;

import android.app.Application;

import com.bawei.week3demo_zqf.Utils.CrashHandler;

public class CrashApplication extends Application {
    @Override  
    public void onCreate() {  
        super.onCreate();  
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
} 