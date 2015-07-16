package com.androidex.adapter.singletype;


import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidex.R;

/**
 * 通用 ViewHolder
 * @author Tom
 */
public class ExViewHolder {


    private SparseArray<View> mViews;
    private View mConverView;

    public ExViewHolder(View rootView) {

        this.mConverView = rootView;
        this.mViews = (SparseArray<View>) mConverView.getTag(R.id.tag_SparseArray);
        if (mViews == null) {
            mViews = new SparseArray<>();
            mConverView.setTag(R.id.tag_SparseArray, mViews);
        }
    }


    public static ExViewHolder getInstance(View view) {
        ExViewHolder instance = (ExViewHolder) view.getTag(R.id.tag_viewHolder);
        if (instance == null) {
            instance = new ExViewHolder(view);
            view.setTag(R.id.tag_viewHolder, instance);
        }
        return instance;
    }

    /**
     * 根据viewId获取控件对象
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);
        if (view == null) {
            view = mConverView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


    public View getConverView() {
        return mConverView;
    }


    /**
     * ===================================以下设置常用控件赋值=======================
     */
    public ExViewHolder setText(int viewId, String txt) {
        TextView tv = getView(viewId);
        tv.setText(txt);
        return this;
    }

    public ExViewHolder setImageResource(int viewId, int resId) {
        ImageView imageViewv = getView(viewId);
        imageViewv.setImageResource(resId);
        return this;
    }

    public ExViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageViewv = getView(viewId);
        imageViewv.setImageBitmap(bitmap);
        return this;
    }
}
