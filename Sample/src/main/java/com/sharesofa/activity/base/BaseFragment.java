package com.sharesofa.activity.base;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.androidex.activity.ExFragment;
import com.androidex.utils.ToastUtil;
import com.androidex.utils.ViewUtil;

/**
 * 1.show MainView
 * 2.show TripView(EmptyView&NetErrorView ..)
 *
 * @author tom
 */
public abstract class BaseFragment extends ExFragment {




    /**
     * Umeng Event part
     */
     //TODO


    /**
     * view util part
     */
    protected void showView(View v) {

        ViewUtil.showView(v);
    }

    protected void hideView(View v) {

        ViewUtil.hideView(v);
    }

    protected void goneView(View v) {

        ViewUtil.goneView(v);
    }

    protected void showImageView(ImageView v, int imageResId) {

        ViewUtil.showImageView(v, imageResId);
    }

    protected void showImageView(ImageView v, Drawable drawable) {

        ViewUtil.showImageView(v, drawable);
    }

    protected void hideImageView(ImageView v) {

        ViewUtil.hideImageView(v);
    }

    protected void goneImageView(ImageView v) {

        ViewUtil.goneImageView(v);
    }

    /**
     * toast util part
     */

    protected void showToast(String toastStr) {

        ToastUtil.showToast(toastStr);
    }

    protected void showToast(int rStrid) {

        ToastUtil.showToast(rStrid);
    }
}
