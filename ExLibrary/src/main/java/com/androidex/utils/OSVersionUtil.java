package com.androidex.utils;

import android.os.Build;

/**
 * Android OS 版本工具类
 */
public class OSVersionUtil {

    public static final int FROYO = 8;
    public static final int GINGERBREAD = 9;
    public static final int GINGERBREAD_MR1 = 10;
    public static final int HONEYCOMB = 11;
    public static final int HONEYCOMB_MR1 = 12;
    public static final int HONEYCOMB_MR2 = 13;
    public static final int ICE_CREAM_SANDWICH = 14;
    public static final int ICE_CREAM_SANDWICH_MR1 = 15;

    public static final int JELLY_BEAN = 16;
    public static final int JELLY_BEAN_MR1 = 17;
    public static final int JELLY_BEAN_MR2 = 18;
    public static final int KITKAT = 19;
    public static final int KITKAT_WATCH = 20;
    public static final int LOLLIPOP = 21;


    public static int buildVersion() {

        return Build.VERSION.SDK_INT;
    }

}
