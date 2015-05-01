package com.androidex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @Description 通用的Adapter，能满足大多简单的Listview适配，简化Code
 */
public abstract class ExCommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas, mDatasBackup;
    protected LayoutInflater mInflater;
    protected int mLayoutId;
    private OnItemViewClickListener mOnItemViewClickLisn;
    private OnItemViewLongClickListener mOnItemViewLongClickLisn;


    private ExCommonAdapter(Context context, List<T> datas, int layoutId) {

        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(mContext);
        this.mLayoutId = layoutId;
    }

    private ExCommonAdapter(Context context, int layoutId) {

        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.mLayoutId = layoutId;
    }


    public void setData(List<T> data) {

        mDatas = data;
        mDatasBackup = null;
    }


    public void add(T item) {

        if (mDatas != null && item != null) {
            mDatas.add(item);
        }
    }

    public void addAll(List<T> data) {

        if (data == null) {
            return;
        }

        if (mDatas == null) {
            mDatas = data;
        } else {
            mDatas.addAll(data);
        }
    }


    public void remove(T item) {

        if (mDatas != null) {
            mDatas.remove(item);
        }
    }

    public void remove(int position) {

        if (mDatas != null) {
            mDatas.remove(position);
        }
    }

    public void removeAll() {

        if (mDatas != null) {
            mDatas.clear();
        }
    }

    public void clear(){

        if(mDatas != null){
            mDatas.clear();
        }
        mDatasBackup = null;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public abstract View getView(int position, View convertView, ViewGroup parent);


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ExViewHolder holder = ExViewHolder.get(mContext, convertView, parent, mLayoutId, position);

        convert(holder, getItem(position));

        return holder.getConverView();
    }


    public abstract void convert(ExViewHolder holder, T bean);




    /*
     * click listener part
	 */

    public void setOnItemViewClickListener(OnItemViewClickListener lisn) {

        mOnItemViewClickLisn = lisn;
    }

    public void setOnItemViewLongClickListener(OnItemViewLongClickListener lisn) {

        mOnItemViewLongClickLisn = lisn;
    }

    protected void callbackOnItemViewClickListener(int position, View view) {

        if (mOnItemViewClickLisn != null)
            mOnItemViewClickLisn.onViewClick(position, view);
    }

    protected void callbackOnItemViewLongClickListener(int position, View view) {

        if (mOnItemViewLongClickLisn != null)
            mOnItemViewLongClickLisn.onViewLongClick(position, view);
    }

}
