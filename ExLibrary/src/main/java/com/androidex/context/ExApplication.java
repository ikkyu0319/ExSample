package com.androidex.context;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;

import java.io.File;

/**
 * 有问题，获取不到上下文
 * 
 * @author zhixing.lan
 * 
 */
public class ExApplication extends Application {

	private static Context mContext = null;

	@Override
	public void onCreate() {

		super.onCreate();
		mContext = getApplicationContext();
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
