package com.androidex.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * RecyclerViewAdapter 通用RecyclerView.ViewHolder
 */
public class ExRecyclerViewHolder extends RecyclerView.ViewHolder {


    SparseArray<View> mViews;
    View mConverView;

    public ExRecyclerViewHolder(View itemView) {

        super(itemView);

        this.mViews = new SparseArray<View>();
        this.mConverView = itemView;
        this.mConverView.setTag(this);
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

    /**
     * ===================================以下设置常用控件赋值=======================
     */
    public void setText(int viewId, String txt) {
        TextView tv = getView(viewId);
        tv.setText(txt);
    }

    public void setImageResource(int viewId, int resId) {
        ImageView imageViewv = getView(viewId);
        imageViewv.setImageResource(resId);
    }

    public void setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageViewv = getView(viewId);
        imageViewv.setImageBitmap(bitmap);
    }


}
