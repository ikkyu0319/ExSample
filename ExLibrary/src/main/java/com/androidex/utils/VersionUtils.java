package com.androidex.utils;

/**
 * 系统版本
 */
public class VersionUtils {


    private VersionUtils() {
    }


    public static final int JELLY_BEAN_MR1 = 17;
    public static final int JELLY_BEAN_MR2 = 18;

    /**
     * October 2013: Android 4.4, KitKat, another tasty treat.
     * <p>
     * <p>Applications targeting this or a later release will get these
     * new changes in behavior:</p>
     * <ul>
     * <li> The default result of
     * {@link android.preference.PreferenceActivity#isValidFragment(String)
     * PreferenceActivity.isValueFragment} becomes false instead of true.</li>
     * <li> In {@link android.webkit.WebView}, apps targeting earlier versions will have
     * JS URLs evaluated directly and any result of the evaluation will not replace
     * the current page content.  Apps targetting KITKAT or later that load a JS URL will
     * have the result of that URL replace the content of the current page</li>
     * <li> {@link android.app.AlarmManager#set AlarmManager.set} becomes interpreted as
     * an inexact value, to give the system more flexibility in scheduling alarms.</li>
     * <li> {@link android.content.Context#getSharedPreferences(String, int)
     * Context.getSharedPreferences} no longer allows a null name.</li>
     * <li> {@link android.widget.RelativeLayout} changes to compute wrapped content
     * margins correctly.</li>
     * <li> {@link android.app.ActionBar}'s window content overlay is allowed to be
     * drawn.</li>
     * <li>The {@link android.Manifest.permission#READ_EXTERNAL_STORAGE}
     * permission is now always enforced.</li>
     * <li>Access to package-specific external storage directories belonging
     * to the calling app no longer requires the
     * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} or
     * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE}
     * permissions.</li>
     * </ul>
     */
    public static final int KITKAT = 19;
    public static final int KITKAT_WATCH = 20;
    public static final int L = 21;
    public static final int LOLLIPOP = 21;
    public static final int LOLLIPOP_MR1 = 22;

    /**
     * M comes after L.
     */
    public static final int M = 23;

    /**
     * Renderscript >=18
     */
    public static boolean canDeviceRunRenderscript() {
        return isAtLeastJellyBeanMR2();
    }

    /**
     * 4.1 JELLY_BEAN
     */
    public static boolean isJellyBean() {
        return android.os.Build.VERSION.SDK_INT == 16;
    }

    /**
     * >=4.2 JELLY_BEAN_MR1
     */
    public static boolean isAtLeastJellyBeanMR1() {
        return android.os.Build.VERSION.SDK_INT >= 17;
    }

    /**
     * >=4.3 JELLY_BEAN_MR2
     */
    public static boolean isAtLeastJellyBeanMR2() {
        return android.os.Build.VERSION.SDK_INT >= 18;
    }

    /**
     * >=4.4  KITKAT
     */
    public static boolean isAtLeastKitKat() {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }

    /**
     * >=5.0 LOLLIPOP & L
     */
    public static boolean isAtLeastLollipop() {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }

    /**
     * >=5.1 LOLLIPOP_MR1
     */
    public static boolean isAtLeastLollipopMR1() {
        return android.os.Build.VERSION.SDK_INT >= 22;
    }

    /**
     * >=6.0  M
     */
    public static boolean isAtLeastMarshmallow() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

}

