package com.alex.study;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        initAroter();
        initAroter();
    }

    private void initAroter(){

        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }
}
