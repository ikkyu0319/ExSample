package com.androidex.utils;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidex.context.ExApplication;


/**
 * 视图帮助类
 */
public class ViewUtil {


    /**
     * set view Visible
     *
     * @param v
     */
    public static void showView(View v) {

        if (v.getVisibility() != View.VISIBLE)
            v.setVisibility(View.VISIBLE);
    }

    /**
     * set view inVisible
     *
     * @param v
     */
    public static void hideView(View v) {

        if (v.getVisibility() != View.INVISIBLE)
            v.setVisibility(View.INVISIBLE);
    }

    /**
     * set view GONE
     *
     * @param v
     */
    public static void goneView(View v) {

        if (v.getVisibility() != View.GONE)
            v.setVisibility(View.GONE);
    }


    public static void showImageView(ImageView v, int imageResId) {

        if (imageResId > 0) {
            v.setImageResource(imageResId);
        } else {
            v.setImageDrawable(null);
        }

        if (v.getVisibility() != View.VISIBLE)
            v.setVisibility(View.VISIBLE);
    }


    public static void showImageView(ImageView v, Drawable drawable) {

        v.setImageDrawable(drawable);
        if (v.getVisibility() != View.VISIBLE)
            v.setVisibility(View.VISIBLE);
    }

    public static void hideImageView(ImageView v) {

        if (v.getVisibility() != View.INVISIBLE) {

            v.setVisibility(View.INVISIBLE);
        }
        v.setImageDrawable(null);
    }

    public static void goneImageView(ImageView v) {

        if (v.getVisibility() != View.GONE) {

            v.setVisibility(View.GONE);
        }
        v.setImageDrawable(null);
    }


    public static void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
                    MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    public static View inflateLayout(int rLayoutId) {
        return LayoutInflater.from(ExApplication.getContext()).inflate(
                rLayoutId, null);
    }


    public static View inflateSpaceView(int layoutParamWidth, int layoutParamHeight) {

        View v = new View(ExApplication.getContext());
        v.setLayoutParams(new ViewGroup.LayoutParams(layoutParamWidth, layoutParamHeight));
        return v;
    }

}
