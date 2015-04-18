package com.androidex.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Tom
 */
public class ExViewHolder {


    private SparseArray<View> mViews;
    private int mPosition;
    private View mConverView;

    public ExViewHolder(Context context, ViewGroup parent, int layoutId, int position) {

        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        this.mConverView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        this.mConverView.setTag(this);
    }

    public static ExViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {


        if (convertView == null) {
            return new ExViewHolder(context, parent, layoutId, position);
        } else {
            ExViewHolder holder = (ExViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
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

    public int getPosition() {
        return mPosition;
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
