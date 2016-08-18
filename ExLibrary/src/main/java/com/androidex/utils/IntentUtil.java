package com.androidex.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import java.io.File;

/**
 * 常用启动项
 * <p>
 * 调用拨打电话。发送短信，打开浏览器，跳转地图
 */
public class IntentUtil {

    // Map 相关参数
    private static String MAP_URL = "https://ditu.google.cn/maps?hl=zh&mrt=loc&";

    /**
     * 调用应用市场
     */
    public static void toAppMarketActivity(Activity activity) {

        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + activity.getPackageName()));
            //存在手机里没安装应用市场的情况，跳转会包异常，做一个接收判断
            if (intent.resolveActivity(activity.getPackageManager()) != null) { //可以接收
                activity.startActivity(intent);
            } else { //没有应用市场，我们通过浏览器跳转到Google Play
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + activity.getPackageName()));
                //这里存在一个极端情况就是有些用户浏览器也没有，再判断一次
                if (intent.resolveActivity(activity.getPackageManager()) != null) { //有浏览器
                    activity.startActivity(intent);
                } else { //
                    Toast.makeText(activity, "天啊，您没安装应用市场，连浏览器也没有，您买个手机干啥？", Toast.LENGTH_SHORT).show();
                }
            }
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
    public static void toPhoneWebBrowser(Activity activity, String url) {

        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        activity.startActivity(intent);
    }

    /**
     * 显示地图(单点)
     *
     * @param activity
     * @param lat
     * @param lng
     * @param tag
     */
    public static void toMap(Activity activity, double lat, double lng, String label) {

        String uriBegin = "geo:" + lat + "," + lng;
        String uriString = uriBegin + "?q=" + label + "";
        Uri uri = Uri.parse(uriString);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        activity.startActivity(intent);
    }


    /**
     * 地图 两点直接连线
     *
     * @param act
     * @param slat
     * @param slng
     * @param elat
     * @param elng
     */
    public static void startGoogleMapAppShowRoute(Activity act, double slat, double slng, double elat, double elng) {

        String url = MAP_URL + "saddr=" + slat + "," + slng + "&daddr=" + elat + "," + elng;
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK & Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        i.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        act.startActivity(i);
    }

    /**
     * 地图 两点直接连线 Web
     *
     * @param act
     * @param slat
     * @param slng
     * @param elat
     * @param elng
     */
    public static void startGoogleMapWebShowRoute(Activity act, double slat, double slng, double elat, double elng) {

        String url = MAP_URL + "saddr=" + slat + "," + slng + "&daddr=" + elat + "," + elng;
        try {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            act.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * to应用详情页
     */
    public static void toAppDetail(Activity activity, String strPackageName) {

        Uri uri = Uri.fromParts("package", strPackageName, null);
        Intent it = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, uri);
        activity.startActivity(it);
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
     * strPackageName=Environment.getExternalStorageDirectory() + "/download/" + "app.apk"
     */
    public static void toInstallApk(Activity activity, String strPackageName) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(strPackageName)), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }


    /**
     * 打开网络设置界面
     */
    public static void openSetting(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings",
                "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }

}
