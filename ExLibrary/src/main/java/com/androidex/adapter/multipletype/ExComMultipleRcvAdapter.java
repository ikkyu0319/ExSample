package com.androidex.adapter.multipletype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.androidex.adapter.singletype.ExViewHolder;

import java.util.HashMap;
import java.util.List;


/**
 * RecyclerView adapter ，支持多类型
 *
 * @author tom
 */
public abstract class ExComMultipleRcvAdapter<T extends MultipleAdapterBean> extends RecyclerView.Adapter {

    private List<T> mData;
    private int mPosition;

    protected ExComMultipleRcvAdapter(List<T> data) {
        mData = data;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * instead by getData().get(position).getDataType()
     */
    @Deprecated
    @Override
    public int getItemViewType(int position) {
        mPosition = position;
        return getRealType(mData.get(position).getDataType());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RcvAdapterItem(parent.getContext(), initItemView(mData.get(mPosition).getDataType()));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RcvAdapterItem) holder).setViews(getItemByType(mData.get(position).getDataType()), mData.get(position), position);
    }

    protected abstract
    @NonNull MultipleAdapterItem<T> initItemView(Object type);

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

    private SparseArray<Object> mItemTypeSparseArr = new SparseArray<>();

    private int getRealType(Object type) {

        int realType = mItemTypeSparseArr.indexOfValue(type);
        if (realType == -1) {
            mItemTypeSparseArr.put(mItemTypeSparseArr.size() - 1, type);
            realType = mItemTypeSparseArr.size() - 1;
        }
        return realType;
    }


    /**
     * 可以被复写用于单条刷新等
     */
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


    public List<T> getData() {
        return mData;
    }

    private class RcvAdapterItem extends RecyclerView.ViewHolder {

        public RcvAdapterItem(Context context, MultipleAdapterItem item) {
            super(LayoutInflater.from(context).inflate(item.getLayoutResId(), null));
        }

        /**
         * 设置Item内部view的方法
         *
         * @param model    数据对象
         * @param position 当前item的position
         */
        public void setViews(MultipleAdapterItem<T> item, T model, int position) {
            item.initViews(ExViewHolder.getInstance(itemView), model, position);
        }
    }
}
