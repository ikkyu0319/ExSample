package com.androidex.adapter.singletype;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.androidex.adapter.ExLvViewHolder;
import com.androidex.adapter.OnItemViewClickListener;
import com.androidex.adapter.OnItemViewLongClickListener;

import java.util.List;

/**
 * 通用的Adapter配合ExViewHolder，能满足大多简单的Listview适配，简化Code
 *
 * @author tom
 */
public abstract class ExCommonLvAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected int mLayoutId;
    private OnItemViewClickListener mOnItemViewClickLisn;
    private OnItemViewLongClickListener mOnItemViewLongClickLisn;


    public ExCommonLvAdapter(Context context, List<T> datas, @LayoutRes int layoutId) {

        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(mContext);
        this.mLayoutId = layoutId;
    }

    public ExCommonLvAdapter(Context context, @LayoutRes int layoutId) {

        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.mLayoutId = layoutId;
    }


    public void setData(List<T> data) {

        mDatas = data;
    }


    public void add(T item) {

        if (mDatas != null && item != null) {
            mDatas.add(item);
        }
    }

    public void add(int position, T item) {

        if (mDatas != null && item != null) {
            mDatas.add(position, item);
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


        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, null);
        }
        ExLvViewHolder holder = ExLvViewHolder.getInstance(convertView);

        convert(holder, getItem(position));

        return holder.getConverView();
    }


    public abstract void convert(ExLvViewHolder holder, T bean);

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
            mOnItemViewClickLisn.onViewClick(position, getItem(position), view);
    }

    protected void callbackOnItemViewLongClickListener(int position, View view) {

        if (mOnItemViewLongClickLisn != null)
            mOnItemViewLongClickLisn.onViewLongClick(position, getItem(position), view);
    }


}
