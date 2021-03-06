package com.androidex.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.androidex.context.ExApplication;

import java.util.List;

/**
 * 获取APP相关的属性，参数
 */
public class AppInfoUtil {


    /**
     * App name
     * @return
     */
    public static String getAppName() {

        try {
            Context ctx = ExApplication.getContext();
            PackageManager packageManager = ctx.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), 0);
            CharSequence charSequcence = packageManager.getApplicationLabel(applicationInfo);
            if (charSequcence == null) {
                return "";
            } else {
                return charSequcence.toString();
            }
        } catch (Exception e) {

            if (LogA.isDebug()) e.printStackTrace();
        }

        return "";
    }

    /**
     * 获取渠道名称
     */
    public static String getChannelName() {

        try {
            Context ctx = ExApplication.getContext();
            ApplicationInfo appInfo = ctx.getPackageManager()
                    .getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
            String channelName = appInfo.metaData.getString("UMENG_CHANNEL");
            return channelName == null ? "" : channelName;
        } catch (NameNotFoundException e) {

            if (LogA.isDebug()) e.printStackTrace();
        }

        return "";
    }

    /**
     * 获取metaName 对应的值
     */
    public static String getMetaDataValue(String metaName) {

        String value = null;
        try {

            Context ctx = ExApplication.getContext();
            ApplicationInfo appInfo = ctx.getPackageManager()
                    .getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(metaName);
        } catch (NameNotFoundException e) {

            if (LogA.isDebug()) e.printStackTrace();
        }

        return value == null ? "" : value;
    }

    /**
     * 获取version code
     */
    public static String getVersionCode() {

        try {

            Context ctx = ExApplication.getContext();
            PackageInfo packInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);

            return packInfo.versionCode == 0 ? "1" : String.valueOf(packInfo.versionCode);
        } catch (NameNotFoundException e) {

            if (LogA.isDebug()) e.printStackTrace();
        }

        return "1";
    }

    /**
     * 获取VersionName
     */
    public static String getVersionName() {

        try {

            Context ctx = ExApplication.getContext();
            PackageInfo packInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            return packInfo.versionName == null ? "" : packInfo.versionName;
        } catch (Exception e) {

            if (LogA.isDebug()) e.printStackTrace();
        }

        return "";
    }

    /**
     * 运行时的内存
     *
     * @return
     */
    public static long getRuntimeMaxMemory() {

        return Runtime.getRuntime().maxMemory();
    }

    /**
     * 获取应用第一次安装时间
     *
     * @return
     */
    public static long getInstallAppTime() {

        long firstInstallTime = 0;

        try {

            Context ctx = ExApplication.getContext();
            PackageInfo packageInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            firstInstallTime = packageInfo.firstInstallTime;// 应用第一次安装的时间
        } catch (NameNotFoundException e) {

            if (LogA.isDebug()) e.printStackTrace();
        }

        return firstInstallTime;
    }

    /**
     * 区分是否在服务进程
     *
     * @return
     */
    public static boolean shouldInit(Context context) {

        try {
            ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
            List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
            String mainProcessName = context.getPackageName();
            int myPid = android.os.Process.myPid();
            for (ActivityManager.RunningAppProcessInfo info : processInfos) {
                if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (LogA.isDebug()) e.printStackTrace();
        }
        return false;
    }

    /**
     * need < uses-permission android:name =“android.permission.GET_TASKS” />
     * 判断是否前台运行
     *
     * @return
     */
    public static boolean isForeGround(Context context) {

        try {
            ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
            List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
            String mainProcessName = context.getPackageName();
            int myPid = android.os.Process.myPid();
            for (ActivityManager.RunningAppProcessInfo info : processInfos) {
                if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                    if (info.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                            || info.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            if (LogA.isDebug()) e.printStackTrace();
        }
        return false;
    }
}
