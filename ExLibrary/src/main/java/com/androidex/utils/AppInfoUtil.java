package com.androidex.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.androidex.context.ExApplication;

import java.util.List;


/**
 * 获取APP相关的属性，参数
 */
public class AppInfoUtil {

    public static String getAppName() {

        try {
            Context ctx = ExApplication.getContext();
            PackageManager packageManager = ctx.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), 0);
            CharSequence charSequcence = packageManager.getApplicationLabel(applicationInfo);
            if (charSequcence == null)
                return "";
            else
                return charSequcence.toString();

        } catch (Exception e) {

            if (LogA.isDebug())
                e.printStackTrace();
        }

        return "";
    }

    public static String getChannelName() {

        try {
            Context ctx = ExApplication.getContext();
            ApplicationInfo appInfo = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
            String channelName = appInfo.metaData.getString("UMENG_CHANNEL");
            return channelName == null ? "" : channelName;

        } catch (NameNotFoundException e) {

            if (LogA.isDebug())
                e.printStackTrace();
        }

        return "";
    }

    public static String getMetaDataValue(String name) {

        String value = null;
        try {

            Context ctx = ExApplication.getContext();
            ApplicationInfo appInfo = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(name);

        } catch (NameNotFoundException e) {

            if (LogA.isDebug())
                e.printStackTrace();
        }

        return value == null ? "" : value;
    }

    public static String getVersionCode() {

        try {

            Context ctx = ExApplication.getContext();
            PackageInfo packInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);

            return packInfo.versionCode == 0 ? "1" : String.valueOf(packInfo.versionCode);

        } catch (NameNotFoundException e) {

            if (LogA.isDebug())
                e.printStackTrace();
        }

        return "1";
    }

    public static String getVersionName() {

        try {

            Context ctx = ExApplication.getContext();
            PackageInfo packInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            return packInfo.versionName == null ? "" : packInfo.versionName;

        } catch (Exception e) {

            if (LogA.isDebug())
                e.printStackTrace();
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
     * 获取手机的IMEI
     *
     * @return
     */
    public static String getIMEI() {

        String imei = "";
        try {

            Context ctx = ExApplication.getContext();
            TelephonyManager telephonyManager = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager != null) {

                imei = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(imei))
                    imei = Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);

                if (imei == null)
                    imei = "";
            }

        } catch (Exception e) {

        }

        return imei;
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

            if (LogA.isDebug())
                e.printStackTrace();
        }

        return firstInstallTime;
    }

    /**
     * 区分是否在服务进程
     */

    public static boolean shouldInit(Context context) {

        try {
            ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
            List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
            String mainProcessName = context.getPackageName();
            int myPid = android.os.Process.myPid();
            for (ActivityManager.RunningAppProcessInfo info : processInfos) {
                if (info.pid == myPid
                        && mainProcessName.equals(info.processName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (LogA.isDebug())
                e.printStackTrace();
        }
        return false;
    }


    public static boolean isForeGround(Context context) {

        try {
            ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
            List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
            String mainProcessName = context.getPackageName();
            int myPid = android.os.Process.myPid();
            for (ActivityManager.RunningAppProcessInfo info : processInfos) {
                if (info.pid == myPid
                        && mainProcessName.equals(info.processName)) {
                    if (info.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND || info.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            if (LogA.isDebug())
                e.printStackTrace();
        }
        return false;
    }
}
