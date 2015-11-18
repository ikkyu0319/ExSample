package com.androidex.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.androidex.context.ExApplication;

/**
 * 判断网络状态
 */
public class NetUtil {

    private NetUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 网络正常
     * @return
     */
    public static boolean isNetworkEnable() {
        ConnectivityManager conManager = (ConnectivityManager) ExApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    /**
     * 没连上网络
     * @return
     */
    public static boolean isNetworkDisable() {
        ConnectivityManager conManager = (ConnectivityManager) ExApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conManager.getActiveNetworkInfo();
        return networkInfo == null || !networkInfo.isAvailable();
    }


    /**
     * 判断是否是wifi连接
     */
    public static boolean isWifiNet() {
        ConnectivityManager cm = (ConnectivityManager) ExApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null)
            return false;
        return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;

    }

    /**
     * 判断是手机网络
     *
     * @return
     */
    public static boolean isMobileNet() {

        ConnectivityManager cm = (ConnectivityManager) ExApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null || cm.getActiveNetworkInfo() == null)
            return false;
        return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_MOBILE;
    }




}
