package com.androidex.utils;

import android.util.TypedValue;

import com.androidex.context.ExApplication;

/**
 * 常用单位转换的辅助类
 */
public class DensityUtil {


    private DensityUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     *
     * @return
     */
    public static int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, ExApplication.getContext().getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @return
     */
    public static int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, ExApplication.getContext().getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @return
     */
    public static float px2dp(float pxVal) {
        final float scale = ExApplication.getContext().getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param fontScale
     * @return
     */
    public static float px2sp(float px) {
        return (px / ExApplication.getContext().getResources().getDisplayMetrics().scaledDensity);
    }

}
