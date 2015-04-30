package com.androidex.activity;


/**
 * Activity 的常用配置
 */
public class ExActivityParams {

    private static int mAppBgColor; //App背景
    private static int mToolbarHeight; //TitleBar高度
    private static int mStatusBarColor; //StatusBar颜色值，5.0以上
    private static int mToolbarBgColor; //toolbar 颜色值
    private static int mTitleViewTextColor = Integer.MAX_VALUE;  //主 Title字体颜色
    private static int mTitleViewTitleTextSize;// Only One标题时，字体的大小
    private static int mTitleViewMainTextSize;//主标题大小
    private static int mTitleViewSubTextSize; //副标题大小
    private static int mTitleViewSubTextColor = mTitleViewTextColor;  //副Title color
    private static int mTitleViewBackBgResId; //返回按钮的资源


    public static int getAppBgColor() {
        return mAppBgColor;
    }

    public static void setAppBgColor(int mAppBgColor) {
        ExActivityParams.mAppBgColor = mAppBgColor;
    }

    public static int getStatusBarColor() {
        return mStatusBarColor;
    }

    public static void setStatusBarColor(int mStatusBarColor) {
        ExActivityParams.mStatusBarColor = mStatusBarColor;
    }

    public static int getTitleViewBackBgResId() {
        return mTitleViewBackBgResId;
    }

    public static void setTitleViewBackBgResId(int mTitleViewBackBgResId) {
        ExActivityParams.mTitleViewBackBgResId = mTitleViewBackBgResId;
    }

    public static int getTitleViewMainTextSize() {
        return mTitleViewMainTextSize;
    }

    public static void setTitleViewMainTextSize(int mTitleViewMainTextSize) {
        ExActivityParams.mTitleViewMainTextSize = mTitleViewMainTextSize;
    }

    public static int getTitleViewSubTextColor() {
        return mTitleViewSubTextColor;
    }

    public static void setTitleViewSubTextColor(int mTitleViewSubTextColor) {
        ExActivityParams.mTitleViewSubTextColor = mTitleViewSubTextColor;
    }

    public static int getTitleViewSubTextSize() {
        return mTitleViewSubTextSize;
    }

    public static void setTitleViewSubTextSize(int mTitleViewSubTextSize) {
        ExActivityParams.mTitleViewSubTextSize = mTitleViewSubTextSize;
    }

    public static int getTitleViewTextColor() {
        return mTitleViewTextColor;
    }

    public static void setTitleViewTextColor(int mTitleViewTextColor) {
        ExActivityParams.mTitleViewTextColor = mTitleViewTextColor;
    }

    public static int getTitleViewTitleTextSize() {
        return mTitleViewTitleTextSize;
    }

    public static void setTitleViewTitleTextSize(int mTitleViewTitleTextSize) {
        ExActivityParams.mTitleViewTitleTextSize = mTitleViewTitleTextSize;
    }

    public static int getToolbarBgColor() {
        return mToolbarBgColor;
    }

    public static void setToolbarBgColor(int mToolbarBgColor) {
        ExActivityParams.mToolbarBgColor = mToolbarBgColor;
    }

    public static int getToolbarHeight() {
        return mToolbarHeight;
    }

    public static void setToolbarHeight(int mToolbarHeight) {
        ExActivityParams.mToolbarHeight = mToolbarHeight;
    }
}
