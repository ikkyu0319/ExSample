package com.androidex.activity;


public class ExActivityParams {

    private static int mBackgroundResId; //App背景
    private static int mTitleViewHeight; //TitleBar高度
    private static int mTitleViewBgResId; //TitleBar 背景色
    private static int mStatusBarColor; //StatusBar颜色值，5.0以上
    private static int mToolbarBgColor; //toolbar 颜色值
    private static int mTitleViewTextColor = Integer.MAX_VALUE;  //主 Title


    private static int mTitleViewTitleTextSize;
    private static int mTitleViewClickerTextSize;
    private static int mTitleViewMainTextSize;
    private static int mTitleViewSubTextSize;
    private static int mTitleViewSubTextColor = mTitleViewTextColor;  //副Title color

    private static int mTitleViewClickerBgResId;
    private static int mTitleViewTextClickerHoriPadding;
    private static int mTitleViewImageClickerBackIconResId;


    public static void setBackgroundResId(int bgResId) {

        mBackgroundResId = bgResId;
    }

    public static int getBackgroundResId() {

        return mBackgroundResId;
    }

    public static void setTitleViewHeight(int heightPx) {

        mTitleViewHeight = heightPx;
    }

    public static int getTitleViewHeight() {

        return mTitleViewHeight;
    }

    public static void setTitleViewBackgroundResId(int resId) {

        mTitleViewBgResId = resId;
    }

    public static int getTitleViewBackgroundResId() {

        return mTitleViewBgResId;
    }

    public static int getStatusBarColor() {
        return mStatusBarColor;
    }

    public static void setStatusBarColor(int statusBarColor) {
        mStatusBarColor = statusBarColor;
    }

    public static int getToolbarBgColor() {
        return mToolbarBgColor;
    }

    public static void setToolbarBgColor(int toolbarBgColor) {
        mToolbarBgColor = toolbarBgColor;
    }

    public static void setTitleViewTextColor(int color) {

        mTitleViewTextColor = color;
    }

    public static int getTitleViewTextColor() {

        return mTitleViewTextColor;
    }


    public static void setTitleViewSubTextColor(int color) {

        mTitleViewSubTextColor = color;
    }

    public static int getTitleViewSubTextColor() {

        return mTitleViewSubTextColor;
    }

    public static void setTitleViewTitleTextSize(int textSizeDp) {

        mTitleViewTitleTextSize = textSizeDp;
    }

    public static int getTitleViewTitleTextSize() {

        return mTitleViewTitleTextSize;
    }

    public static void setTitleViewClickerTextSize(int textSizeDp) {

        mTitleViewClickerTextSize = textSizeDp;
    }

    public static int getTitleViewClickerTextSize() {

        return mTitleViewClickerTextSize;
    }

    public static void setTitleViewMainTextSize(int mainTextSizeDp) {

        mTitleViewMainTextSize = mainTextSizeDp;
    }

    public static int getTitleViewMainTextSize() {

        return mTitleViewMainTextSize;
    }

    public static void setTitleViewSubTextSize(int subTextSizeDp) {

        mTitleViewSubTextSize = subTextSizeDp;
    }

    public static int getTitleViewSubTextSize() {

        return mTitleViewSubTextSize;
    }

    public static void setTitleViewClickerBgResId(int resId) {

        mTitleViewClickerBgResId = resId;
    }

    public static int getTitleViewClickerBgResId() {

        return mTitleViewClickerBgResId;
    }

    public static void setTitleViewTextClickerHoriPadding(int horiPaddingPx) {

        mTitleViewTextClickerHoriPadding = horiPaddingPx;
    }

    public static int getTitleViewTextClickerHoriPadding() {

        return mTitleViewTextClickerHoriPadding;
    }

    public static void setTitleViewImageClickerBackIconResId(int resId) {

        mTitleViewImageClickerBackIconResId = resId;
    }

    public static int getTitleViewImageClickerBackIconResId() {

        return mTitleViewImageClickerBackIconResId;
    }
}
