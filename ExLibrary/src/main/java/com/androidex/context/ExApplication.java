package com.androidex.context;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import java.io.File;

/**
 * @author Tom
 */
public class ExApplication extends Application {

    private static Context mContext = null;

    public static RefWatcher getRefWatcher(Context context) {
        ExApplication application = (ExApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {

        super.onCreate();
        mContext = getApplicationContext();
        LeakCanary.install(this);
    }

    public static Context getContext() {

        return mContext;
    }

    public static Resources getExResources() {

        return mContext.getResources();
    }

    public static ContentResolver getExContentResolver() {

        return mContext.getContentResolver();
    }

    public static File getAppCacheDir() {

        return mContext.getCacheDir();
    }

    public static File getAppCacheSubDir(String subDirName) {

        File subDir = new File(getAppCacheDir(), subDirName);
        if (!subDir.exists())
            subDir.mkdirs();

        return subDir;
    }
}
