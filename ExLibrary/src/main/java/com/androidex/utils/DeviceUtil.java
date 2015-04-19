package com.androidex.utils;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.*;

import com.androidex.context.ExApplication;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


/**
 * 设备信息
 */
public class DeviceUtil {

    /**
     * 判断是否有电话功能
     *
     * @return true:有电话功能
     * false:没有电话功能
     */
    public static boolean hasPhone() {

        TelephonyManager telephony = (TelephonyManager) ExApplication.getContext().
                getSystemService(Context.TELEPHONY_SERVICE);
        return telephony.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE ? false : true;
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
                if (android.text.TextUtils.isEmpty(imei))
                    imei = Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);

                if (imei == null)
                    imei = "";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return imei;
    }

    /**
     * 获取手机IP地址
     *
     * @return
     */
    private String getPhoneIP() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
