package com.androidex.view.pop;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/**
 * 重新包装的PopWindow，可以使用，
 * 功能还有待继续完善
 *
 * @author yhb
 */
public class ExPopWindow {

    private PopupWindow mPopWindow;
    private FrameLayout mFrameView;
    protected View mAnchorView;
    private int mXOff, mYOff;

    public ExPopWindow(Context context) {

        initPopWindow(context);
    }

    private void initPopWindow(Context context) {

        mPopWindow = new PopupWindow(context);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setFocusable(true);
        mPopWindow.setBackgroundDrawable(new ColorDrawable(00000000));

        mFrameView = new FrameLayout(context);
        mPopWindow.setContentView(mFrameView);
    }

    public void setContentView(View contentView) {

        if (mFrameView.getChildCount() != 0)
            mFrameView.removeAllViews();

        mFrameView.addView(contentView);
    }

    public FrameLayout getFrameView() {

        return mFrameView;
    }

    public View getContentView() {

        return mFrameView.getChildAt(0);
    }

    public void setFramePadding(int left, int top, int right, int bottom) {

        mFrameView.setPadding(left, top, right, bottom);
    }

    public void setFrameBackground(int resId) {

        mFrameView.setBackgroundResource(resId);
    }

    public void setDropDownAttr(View anchor, int xoff, int yoff) {

        mAnchorView = anchor;
        mXOff = xoff;
        mYOff = yoff;
    }

    public void setLayoutParams(int width, int height) {

        mPopWindow.setWidth(width);
        mPopWindow.setHeight(height);
    }

    public void showAsDropDown() {

        mPopWindow.showAsDropDown(mAnchorView, mXOff, mYOff);
    }

    public void dismiss() {

        mPopWindow.dismiss();
    }

    public boolean isShowing() {

        return mPopWindow.isShowing();
    }
}
