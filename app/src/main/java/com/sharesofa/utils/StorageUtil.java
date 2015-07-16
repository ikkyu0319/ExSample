package com.sharesofa.utils;


import android.os.Environment;

import java.io.File;

/**
 * 文件存储目录
 */
public class StorageUtil {

	private static final String TAG = StorageUtil.class.getSimpleName();
	private static String FILE_SCHEMA_PREFIX = "file://";

	public static final String FILE_EXTEND_ZIP = ".zip";
	public static final String FILE_EXTEND_TEMP = ".temp";
	public static final String FILE_EXTEND_HTML = ".html";
	public static final String FILE_EXTEND_TXT = ".txt";
	public static final String FILE_EXTEND_DLI = ".dli";


	private static final String HOME_DIR = "/qyer/qyerplan/";// 大应用主目录
	private static final String PICS_DIR = HOME_DIR + "pics/";// 应用所有网络图片保存目录
	private static final String WEBVIEW_DIR = HOME_DIR+"webview_cache/"; //WebView缓存目录
	private static final String PLAN_URL_CACHE=HOME_DIR+"urlCahe/";//PlanUrl缓存目录


	public static File getExStorageDir() {

		return Environment.getExternalStorageDirectory();
	}

	public static File getHomeDir() {

		File homeDir = new File(getExStorageDir(), HOME_DIR);
		if (!homeDir.exists())
			homeDir.mkdirs();

		return homeDir;
	}

	public static File getPicsDir() {

		File picsDir = new File(getExStorageDir(), PICS_DIR);
		if (!picsDir.exists()) {
			picsDir.mkdirs();
		}

		return picsDir;
	}



	public static File getUrlCaheFileDir() {
		
		File htmlFileDir = new File(getExStorageDir(), PLAN_URL_CACHE);
		if (!htmlFileDir.exists())
			htmlFileDir.mkdirs();
		
		return htmlFileDir;
	}


	public static String getWebViewCachePath() {

		final String path = new StringBuffer(Environment.getExternalStorageDirectory().toString()).append(WEBVIEW_DIR).toString();
		final File dirFile = new File(path);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		return path;
	}

}
