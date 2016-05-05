package com.androidex.utils;

/**
 * 系统版本
 */
public class VersionUtils {


    private VersionUtils() {
    }

    /**
     * Renderscript >=18
     */
    public static boolean canDeviceRunRenderscript() {
        return isAtLeastJellyBeanMR2();
    }

    /**
     * 4.1
     */
    public static boolean isJellyBean() {
        return android.os.Build.VERSION.SDK_INT == 16;
    }

    /**
     * >=4.2
     */
    public static boolean isAtLeastJellyBeanMR1() {
        return android.os.Build.VERSION.SDK_INT >= 17;
    }
    /**
     * >=4.3
     */
    public static boolean isAtLeastJellyBeanMR2() {
        return android.os.Build.VERSION.SDK_INT >= 18;
    }

    /**
     * >=4.4
     */
    public static boolean isAtLeastKitKat() {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }

    /**
     * >=5.0
     */
    public static boolean isAtLeastLollipop() {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }
    /**
     * >=5.1
     */
    public static boolean isAtLeastLollipopMR1() {
        return android.os.Build.VERSION.SDK_INT >= 22;
    }

    /**
     * >=6.0
     */
    public static boolean isAtLeastMarshmallow() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

}

