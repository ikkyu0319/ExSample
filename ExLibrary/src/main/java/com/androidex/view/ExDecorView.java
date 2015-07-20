package com.androidex.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidex.R;


/**
 * 自定义TitleBar，实现了title左中右的根布局
 */
public class ExDecorView extends RelativeLayout {

    private LinearLayout mLlTitleView, mLlTitleLeftView, mLlTitleMiddleView, mLlTitleRightView;
    private Style mStyle;

    public ExDecorView(Context context) {

        super(context);
        initStyle(context.obtainStyledAttributes(R.styleable.ExDecorView));
        initExDecorView(context, false);
    }

    public ExDecorView(Context context, AttributeSet attrs) {

        super(context, attrs);
        initStyle(context.obtainStyledAttributes(attrs, R.styleable.ExDecorView));
        initExDecorView(context, true);
    }

    public ExDecorView(Context context, Style style) {

        super(context);
        initStyle(style);
        initExDecorView(context, false);
    }

    private void initStyle(TypedArray typedArray) {

        mStyle = new Style(typedArray);
        typedArray.recycle();
    }

    private void initStyle(Style style) {

        if (style == null) {
            mStyle = new Style();
        } else {
            mStyle = style;
        }
    }

    private void initExDecorView(Context context, boolean fromAttrs) {

        // 初始化整个ContentView
        if (!fromAttrs)
            setId(R.id.ex_decor_view_root);

        setLayoutParams(new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        if (mStyle.mBackgroundResId != 0)
            setBackgroundResource(mStyle.mBackgroundResId);

        // 添加titleView
        addView(getTitleContentView(context), getRelativeHoriMatchLayoutParamsByTitleHeight());
    }

    @SuppressLint("RtlHardcoded")
    private LinearLayout getTitleContentView(Context context) {

        mLlTitleView = new LinearLayout(context);
        mLlTitleView.setId(R.id.ex_decor_view_title);
        mLlTitleView.setOrientation(LinearLayout.HORIZONTAL);
        if (mStyle.mTitleBackgroundResId != 0)
            mLlTitleView.setBackgroundResource(mStyle.mTitleBackgroundResId);

        // 初始化标题栏左边布局
        mLlTitleLeftView = new LinearLayout(context);
        mLlTitleLeftView.setOrientation(LinearLayout.HORIZONTAL);
        mLlTitleLeftView.setGravity(Gravity.CENTER_VERTICAL);

        // 初始化标题栏中间标题布局
        mLlTitleMiddleView = new LinearLayout(context);
        mLlTitleMiddleView.setOrientation(LinearLayout.VERTICAL);
        if (mStyle.mTitleIsAndroidStyle)
            mLlTitleMiddleView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        else
            mLlTitleMiddleView.setGravity(Gravity.CENTER);

        // 标题栏右边布局
        mLlTitleRightView = new LinearLayout(context);
        mLlTitleRightView.setOrientation(LinearLayout.HORIZONTAL);
        mLlTitleRightView.setGravity(Gravity.CENTER_VERTICAL);

        mLlTitleView.addView(mLlTitleLeftView, getLinearHoriWrapLayoutParamsByTitleHeight(0));
        mLlTitleView.addView(mLlTitleMiddleView, getLinearHoriMatchLayoutParamsByTitleHeight(1));
        mLlTitleView.addView(mLlTitleRightView, getLinearHoriWrapLayoutParamsByTitleHeight(0));

        if (mStyle.mTitleIsNone)
            mLlTitleView.setVisibility(View.GONE);

        return mLlTitleView;
    }

    public Style getStyle() {

        return mStyle;
    }

    public LinearLayout getTitleView() {

        return mLlTitleView;
    }

    public LinearLayout getTitleLeftView() {

        return mLlTitleLeftView;
    }

    public LinearLayout getTitleMiddleView() {

        return mLlTitleMiddleView;
    }

    public LinearLayout getTitleRightView() {

        return mLlTitleRightView;
    }

	/*
     * add title view left part
	 */

    public ImageView addTitleLeftImageViewBack(OnClickListener lisn) {

        return addTitleLeftImageView(mStyle.mTitleBackIconResId, lisn);
    }

    public ImageView addTitleLeftImageView(int icResId, OnClickListener lisn) {

        ImageView iv = getTitleImageView(icResId, lisn);
        mLlTitleLeftView.addView(iv, getLinearLayoutParamsByTitleHeight());
        return iv;
    }

    public ImageView addTitleLeftImageViewHoriWrap(int icResId, OnClickListener lisn) {

        ImageView iv = getTitleImageView(icResId, lisn);
        mLlTitleLeftView.addView(iv, getLinearHoriWrapLayoutParamsByTitleHeight(0));
        return iv;
    }

    public TextView addTitleLeftTextView(int textRid, OnClickListener lisn) {

        return addTitleLeftTextView(getResources().getText(textRid), lisn);
    }

    public TextView addTitleLeftTextView(CharSequence text, OnClickListener lisn) {

        TextView tv = getTitleClickerTextView(text, mStyle.mTitleClickerHoriPadding, lisn);
        mLlTitleLeftView.addView(tv, getLinearHoriWrapLayoutParamsByTitleHeight(0));
        return tv;
    }

    public void addTitleLeftView(View v) {

        mLlTitleLeftView.addView(v);
    }

    public void addTitleLeftView(View v, LinearLayout.LayoutParams lllp) {

        mLlTitleLeftView.addView(v, lllp);
    }

    public void setContentView(View v) {

        setContentView(v, null);
    }

    public void setContentView(View v, RelativeLayout.LayoutParams rllp) {

        if (rllp == null) {

            rllp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
        }
        rllp.topMargin = mStyle.mTitleFloatContentTopMargin;

        if (mStyle.mTitleIsFloat) {

            addView(v, getChildCount() - 1, rllp);
        } else {

            rllp.addRule(BELOW, mLlTitleView.getId());
            addView(v, rllp);
        }
    }

    public void setTitleViewBackgroundAlpha(int alpha) {

        if (mLlTitleView.getBackground() != null)
            mLlTitleView.getBackground().setAlpha(alpha);
    }

    public void setTitleViewBackground(int resId) {

        mLlTitleView.setBackgroundResource(resId);
    }

    @Deprecated
    public void setTitleViewBackground(Drawable drawable) {

        mLlTitleView.setBackgroundDrawable(drawable);
    }

    public void setTitleViewBackgroundColor(int color) {

        mLlTitleView.setBackgroundColor(color);
    }

    /*
     * add title view middle part
     */
    public ImageView addTitleMiddleImageView(int icResId) {

        ImageView iv = getTitleImageView(icResId, null);
        mLlTitleMiddleView.addView(iv, getLinearLayoutParamsByTitleHeight());
        if (!mStyle.mTitleIsAndroidStyle && mLlTitleMiddleView.getChildCount() == 1)
            resetTitleMiddleView();

        return iv;
    }

    public ImageView addTitleMiddleImageViewHoriWrap(int icResId) {

        ImageView iv = getTitleImageView(icResId, null);
        mLlTitleMiddleView.addView(iv, getLinearHoriWrapLayoutParamsByTitleHeight(0));
        if (!mStyle.mTitleIsAndroidStyle && mLlTitleMiddleView.getChildCount() == 1)
            resetTitleMiddleView();

        return iv;
    }

    public TextView addTitleMiddleTextView(int textRid) {

        return addTitleMiddleTextView(getResources().getText(textRid));
    }

    public TextView addTitleMiddleTextView(CharSequence text) {

        TextView tv = getTitleTitleTextView(text, 0, mStyle.mTitleTextIsBold, null);
        mLlTitleMiddleView.addView(tv, getLinearWrapLayoutParams());
        if (!mStyle.mTitleIsAndroidStyle && mLlTitleMiddleView.getChildCount() == 1)
            resetTitleMiddleView();

        return tv;
    }

    public TextView addTitleMiddleTextViewMainStyle(int textRid) {

        return addTitleMiddleTextViewMainStyle(getResources().getString(textRid));
    }

    public TextView addTitleMiddleTextViewMainStyle(CharSequence text) {

        TextView tv = getTitleMainTextView(text, null);
        mLlTitleMiddleView.addView(tv, getLinearWrapLayoutParams());
        if (!mStyle.mTitleIsAndroidStyle && mLlTitleMiddleView.getChildCount() == 1)
            resetTitleMiddleView();

        return tv;
    }

    public TextView addTitleMiddleTextViewSubStyle(int textRid) {

        return addTitleMiddleTextViewSubStyle(getResources().getText(textRid));
    }

    public TextView addTitleMiddleTextViewSubStyle(CharSequence text) {

        TextView tv = getTitleSubTextView(text, null);
        mLlTitleMiddleView.addView(tv, getLinearWrapLayoutParams());
        if (!mStyle.mTitleIsAndroidStyle && mLlTitleMiddleView.getChildCount() == 1)
            resetTitleMiddleView();

        return tv;
    }

    private void resetTitleMiddleView() {

        mLlTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                if (mLlTitleView.getWidth() != 0) {

                    int leftSpace = mLlTitleMiddleView.getLeft();
                    int rightSpace = mLlTitleView.getWidth() - mLlTitleMiddleView.getRight();
                    if (leftSpace > rightSpace) {

                        LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) mLlTitleMiddleView
                                .getLayoutParams();
                        lllp.rightMargin = leftSpace - rightSpace;
                    } else if (leftSpace < rightSpace) {

                        LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) mLlTitleMiddleView
                                .getLayoutParams();
                        lllp.leftMargin = rightSpace - leftSpace;
                    }

                    mLlTitleView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    mLlTitleMiddleView.requestLayout();
                }

            }
        });
    }

    public void addTitleMiddleView(View v) {

        mLlTitleMiddleView.addView(v);
    }

    public void addTitleMiddleView(View v, LinearLayout.LayoutParams lllp) {

        mLlTitleMiddleView.addView(v, lllp);
    }

    /*
     * add title view right part
     */
    public ImageView addTitleRightImageView(int icResId, OnClickListener lisn) {

        ImageView iv = getTitleImageView(icResId, lisn);
        mLlTitleRightView.addView(iv, getLinearLayoutParamsByTitleHeight());
        return iv;
    }

    public ImageView addTitleRightImageViewHoriWrap(int icResId, OnClickListener lisn) {

        ImageView iv = getTitleImageView(icResId, lisn);
        mLlTitleRightView.addView(iv, getLinearHoriWrapLayoutParamsByTitleHeight(0));
        return iv;
    }

    public TextView addTitleRightTextView(int textRid, OnClickListener lisn) {

        return addTitleRightTextView(getResources().getText(textRid), lisn);
    }

    public TextView addTitleRightTextView(CharSequence text, OnClickListener lisn) {

        TextView tv = getTitleClickerTextView(text, mStyle.mTitleClickerHoriPadding, lisn);
        mLlTitleRightView.addView(tv, getLinearHoriWrapLayoutParamsByTitleHeight(0));
        return tv;
    }

    public void addTitleRightView(View v) {

        mLlTitleRightView.addView(v);
    }

    public void addTitleRightView(View v, LinearLayout.LayoutParams lllp) {

        mLlTitleRightView.addView(v, lllp);
    }

    /*
     * title view common part
     */
    private ImageView getTitleImageView(int icResId, OnClickListener lisn) {

        ImageView iv = new ImageView(getContext());
        iv.setScaleType(ScaleType.CENTER_INSIDE);// system default is scaleType.FIT_CENTER

        if (icResId != 0)
            iv.setImageResource(icResId);

        if (mStyle.mTitleClickerBackgroundResId != 0)
            iv.setBackgroundResource(mStyle.mTitleClickerBackgroundResId);

        if (lisn != null)
            iv.setOnClickListener(lisn);

        return iv;
    }

    private TextView getTitleTitleTextView(CharSequence text, int textHoriPaddingDp, boolean textIsBold,
                                           OnClickListener lisn) {

        return getTitleTextView(text, mStyle.mTitleTextColor, mStyle.mTitleTextSize, textHoriPaddingDp, textIsBold,
                lisn);
    }

    private TextView getTitleClickerTextView(CharSequence text, int textHoriPaddingDp, OnClickListener lisn) {

        return getTitleTextView(text, mStyle.mTitleTextColor, mStyle.mTitleClickerTextSize, textHoriPaddingDp, false,
                lisn);
    }

    private TextView getTitleMainTextView(CharSequence text, OnClickListener lisn) {

        return getTitleTextView(text, mStyle.mTitleTextColor, mStyle.mTitleMainTextSize, 0, false, lisn);
    }

    private TextView getTitleSubTextView(CharSequence text, OnClickListener lisn) {

        return getTitleTextView(text, mStyle.mTitleTextColor, mStyle.mTitleSubTextSize, 0, false, lisn);
    }

    private TextView getTitleTextView(CharSequence text, int textColor, int textSizeDp, int textHoriPaddingDp,
                                      boolean isBold, OnClickListener lisn) {

        TextView tv = new TextView(getContext());
        if (isBold)
            tv.getPaint().setFakeBoldText(true);

        tv.setGravity(Gravity.CENTER);
        tv.setSingleLine();
        tv.setEllipsize(TruncateAt.END);
        tv.setText(text);

        if (textHoriPaddingDp > 0)
            tv.setPadding(textHoriPaddingDp, 0, textHoriPaddingDp, 0);

        if (textSizeDp > 0)
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeDp);

        if (textColor != 0)
            tv.setTextColor(textColor);

        if (mStyle.mTitleClickerBackgroundResId != 0)
            tv.setBackgroundResource(mStyle.mTitleClickerBackgroundResId);

        if (lisn != null)
            tv.setOnClickListener(lisn);

        return tv;
    }

    private RelativeLayout.LayoutParams getRelativeHoriMatchLayoutParamsByTitleHeight() {

        return new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                mStyle.mTitleHeight > 0 ? mStyle.mTitleHeight : RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    private LinearLayout.LayoutParams getLinearHoriMatchLayoutParamsByTitleHeight(int weight) {

        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                mStyle.mTitleHeight > 0 ? mStyle.mTitleHeight : LinearLayout.LayoutParams.WRAP_CONTENT, weight);
    }

    private LinearLayout.LayoutParams getLinearHoriWrapLayoutParamsByTitleHeight(int weight) {

        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                mStyle.mTitleHeight > 0 ? mStyle.mTitleHeight : LinearLayout.LayoutParams.WRAP_CONTENT, weight);
    }

    private LinearLayout.LayoutParams getLinearLayoutParamsByTitleHeight() {

        if (mStyle.mTitleHeight > 0)
            return new LinearLayout.LayoutParams(mStyle.mTitleHeight, mStyle.mTitleHeight);
        else
            return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    private LinearLayout.LayoutParams getLinearWrapLayoutParams() {

        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public static class Style {

        public int mBackgroundResId;
        public boolean mTitleIsNone;
        public boolean mTitleIsFloat;
        public boolean mTitleIsAndroidStyle;
        public int mTitleFloatContentTopMargin;
        public int mTitleHeight;

        public int mTitleBackgroundResId;
        public int mTitleTextColor;
        public int mTitleTextSize;
        public boolean mTitleTextIsBold;

        public int mTitleMainTextSize; // 主标题大小
        public int mTitleSubTextSize; // 副标题大小

        public int mTitleClickerBackgroundResId;
        public int mTitleClickerTextSize;

        public int mTitleBackIconResId;
        public int mTitleClickerHoriPadding;

        public Style() {

        }

        protected Style(TypedArray typedArray) {

            mBackgroundResId = typedArray.getResourceId(R.styleable.ExDecorView_exBackground, 0);
            mTitleIsNone = typedArray.getBoolean(R.styleable.ExDecorView_exTitleNone, false);
            mTitleIsFloat = typedArray.getBoolean(R.styleable.ExDecorView_exTitleFloat, false);
            mTitleIsAndroidStyle = typedArray.getBoolean(R.styleable.ExDecorView_exTitleAndroidStyle, false);
            mTitleFloatContentTopMargin = typedArray.getDimensionPixelSize(
                    R.styleable.ExDecorView_exTitleFloatContentTopMargin, 0);

            mTitleHeight = typedArray.getDimensionPixelSize(R.styleable.ExDecorView_exTitleHeight, 0);
            mTitleBackgroundResId = typedArray.getResourceId(R.styleable.ExDecorView_exTitleBackground, 0);
            mTitleTextSize = typedArray.getDimensionPixelSize(R.styleable.ExDecorView_exTitleTextSize, 0);
            mTitleTextColor = typedArray.getColor(R.styleable.ExDecorView_exTitleTextColor, Color.BLACK);

            mTitleTextIsBold = typedArray.getBoolean(R.styleable.ExDecorView_exTitleTextBold, false);
            mTitleMainTextSize = typedArray.getDimensionPixelSize(R.styleable.ExDecorView_exTitleMainTextSize,
                    mTitleTextSize);
            mTitleSubTextSize = typedArray.getDimensionPixelSize(R.styleable.ExDecorView_exTitleSubTextSize,
                    mTitleTextSize);

            mTitleClickerBackgroundResId = typedArray
                    .getResourceId(R.styleable.ExDecorView_exTitleClickerBackground, 0);
            mTitleClickerTextSize = typedArray.getDimensionPixelSize(R.styleable.ExDecorView_exTitleClickerTextSize,
                    mTitleTextSize);

            mTitleBackIconResId = typedArray.getResourceId(R.styleable.ExDecorView_exTitleBackIcon, 0);
            mTitleClickerHoriPadding = typedArray.getDimensionPixelSize(
                    R.styleable.ExDecorView_exTitleClickerHoriPadding, 0);
        }
    }
}
