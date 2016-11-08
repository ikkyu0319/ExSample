package com.androidex.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.androidex.context.ExApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.UUID;

/**
 * 设备硬件相关信息
 */
public class DeviceUtil {

    private static String sID = null;
    private static final String INSTALLATION = "INSTALLATION";

    /**
     * 判断是否有电话功能
     * android.permission.READ_PHONE_STATE
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
     * android.permission.READ_PHONE_STATE
     * 1）非手机设备： 如果只带有Wifi的设备或者音乐播放器没有通话的硬件功能的话就没有这个DEVICE_ID
     * 2）权限： 获取DEVICE_ID需要READ_PHONE_STATE权限，但如果我们只为了获取它，没有用到其他的通话功能，那这个权限有点大才小用
     * 3）bug：在少数的一些手机设备上，该实现有漏洞，会返回垃圾，如:zeros(全是0)或者asterisks(星号)的产品
     */
    public static String getIMEI() {

        String imei = "";
        try {
            Context ctx = ExApplication.getContext();
            TelephonyManager telephonyManager =
                    (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager != null) {

                imei = telephonyManager.getDeviceId();
                if (imei == null) imei = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imei;
    }


    /**
     * ANDROID_ID是设备第一次启动时产生和存储的64bit的一个数，当设备被wipe后该数重置ANDROID_ID似乎是获取Device ID的一个好选择，
     * <p>
     * 但它也有缺陷：
     * 1）它在Android <=2.1 or Android >=2.3的版本是可靠、稳定的，但在2.2的版本并不是100%可靠的
     * 2）在主流厂商生产的设备上，有一个很经常的bug，就是每个设备都会产生相同的ANDROID_ID：9774d56d682e549c
     * 3）厂商定制系统的Bug：有些设备返回的值为null。
     * 4）设备差异：对于CDMA设备，ANDROID_ID和TelephonyManager.getDeviceId() 返回相同的值。
     *
     * @return
     */
    public static String getAndroidId() {

        String androidId = "";
        try {
            Context ctx = ExApplication.getContext();
            androidId = Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return androidId;
    }

    /**
     * 获取手机IP地址
     */
    public static String getPhoneIP() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
                     enumIpAddr.hasMoreElements(); ) {
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


    /**
     * 获取MAC地址
     * android.permission.ACCESS_WIFI_STATE
     * 1）硬件限制：并不是所有的设备都有Wifi和蓝牙硬件，硬件不存在自然也就得不到这一信息。
     * 2）获取的限制：如果Wifi没有打开过，是无法获取其Mac地址的；而蓝牙是只有在打开的时候才能获取到其Mac地址。
     *
     * @param mContext
     * @return
     */
    public static String getMacAddress(Context mContext) {
        String macStr = "";
        try {
            WifiManager wifiManager = (WifiManager) mContext
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            if (wifiInfo.getMacAddress() != null) {
                macStr = wifiInfo.getMacAddress();// MAC地址
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return macStr;
    }

    /**
     * Sim Serial Number
     * 装有SIM卡的设备，可以通过下面的方法获取到Sim Serial Number：
     */
    public static String getSimSerialNumber() {

        String ssNumber = "";
        try {
            Context ctx = ExApplication.getContext();
            TelephonyManager telephonyManager =
                    (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager != null) {

                ssNumber = telephonyManager.getSimSerialNumber();
                if (ssNumber == null) ssNumber = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssNumber;
    }


    /**
     * 获取设备的UUID
     *
     * @param context
     * @return
     */
    public synchronized static String getUUID(Context context) {
        if (sID == null) {
            File installation = new File(context.getFilesDir(), INSTALLATION);
            try {
                if (!installation.exists()) writeInstallationFile(installation);
                sID = readInstallationFile(installation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sID;
    }

    private static String readInstallationFile(File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, "r");
        byte[] bytes = new byte[(int) f.length()];
        f.readFully(bytes);
        f.close();
        return new String(bytes);
    }

    private static void writeInstallationFile(File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        String id = UUID.randomUUID().toString();
        out.write(id.getBytes());
        out.close();
    }

}
