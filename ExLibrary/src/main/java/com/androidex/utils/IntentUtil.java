package com.androidex.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;

/**
 * 常用启动项
 * <p>
 * 调用拨打电话。发送短信，打开浏览器，跳转地图
 */
public class IntentUtil {


    /**
     * 调用应用市场
     */
    public static void toAppStoreSearch(Activity activity) {

        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + activity.getPackageName()));
            intent.setComponent(new ComponentName("android", "com.android.internal.app.ResolverActivity"));
            activity.startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用Google Search
     */
    public static void toGoogleSearch(Activity activity) {

    }


    /**
     * 调用拨打电话
     */
    public static void toPhoneCall(Activity activity) {

    }


    /**
     * 调用发送短信
     */
    public static void toPhoneMessage(Activity activity) {

    }

    /**
     * 调用浏览器
     */
    public static void toPhoneWebBrowser(Activity activity) {

    }

    /**
     * 显示地图
     */
    public static void toPhoneMap(Activity activity) {

    }


    /**
     * 卸载apk
     */
    public static void toUninstallApk(Activity activity, String strPackageName) {

        Uri uri = Uri.fromParts("package", strPackageName, null);
        Intent it = new Intent(Intent.ACTION_DELETE, uri);
        activity.startActivity(it);
    }

    /**
     * 安装apk
     */
    public static void toInstallApk(Activity activity, String strPackageName) {

        //TODO
    }


}
