package com.sharesofa;

import android.app.Application;
import android.content.res.Configuration;


/**
 * Created by tom on 15/5/16.
 */
public class SampleApplication extends Application {


    @Override public void onCreate() {
        super.onCreate();
    }

    @Override public void onLowMemory() {
        super.onLowMemory();
    }

    @Override public void onTerminate() {
        super.onTerminate();
    }

    @Override public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
