package com.androidex.adapter.multipletype;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.androidex.adapter.ExLvViewHolder;

import java.util.HashMap;
import java.util.List;

/**
 * Lv 通用adapter ,支持多类型
 *
 * @author tom
 */
public abstract class ExComMultipleLvAdapter<T extends MultipleAdapterBean> extends BaseAdapter {

    private List<T> mData;

    protected ExComMultipleLvAdapter(List<T> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * instead by getData().get(position).getDataType()
     */
    @Override
    @Deprecated
    public int getItemViewType(int position) {
        return -1;
    }

    @Override
    public int getViewTypeCount() {
        return mData.get(0).getDataTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MultipleAdapterItem<T> item = getItemByType(mData.get(position).getDataType());
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(item.getLayoutResId(), null);
        }
        item.initViews(ExLvViewHolder.getInstance(convertView), mData.get(position), position);
        return convertView;
    }

    protected abstract
    @NonNull MultipleAdapterItem<T> initItemView(Object type);


    public List<T> getData() {
        return mData;
    }

    public void add(T item) {

        if (mData != null && item != null) {
            mData.add(item);
            notifyDataSetChanged();
        }
    }

    public void add(int position, T item) {

        if (mData != null && item != null) {
            mData.add(position, item);
            notifyDataSetChanged();
        }
    }

    public void addAll(List<T> data) {

        if (data == null) {
            return;
        }

        if (mData == null) {
            mData = data;
        } else {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }


    public void remove(T item) {

        if (mData != null) {
            mData.remove(item);
            notifyDataSetChanged();
        }
    }

    public void remove(int position) {

        if (mData != null) {
            mData.remove(position);
            notifyDataSetChanged();
        }
    }

    public void removeAll() {

        if (mData != null) {
            mData.clear();
            notifyDataSetChanged();
        }
    }


    // (type - item) = (key - value)
    private HashMap<Object, MultipleAdapterItem<T>> mItemMap = new HashMap<>();

    /**
     * 根据相应的类型得到item对象
     *
     * @param type item的类型
     */
    private MultipleAdapterItem<T> getItemByType(Object type) {
        MultipleAdapterItem<T> item = mItemMap.get(type);
        if (item == null) {
            item = initItemView(type);
            mItemMap.put(type, item);
        }
        return item;
    }
}
