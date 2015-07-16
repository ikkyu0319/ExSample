package com.androidex.adapter.singletype;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by tom on 15/7/15.
 */
public abstract class ExCommonRcvAdapter<T> extends RecyclerView.Adapter {


    private int mItemLayoutId;
    private List<T> mData;


    protected ExCommonRcvAdapter(List<T> data, int itemLayoutId) {
        mData = data;
        mItemLayoutId = itemLayoutId;
    }

    protected ExCommonRcvAdapter(int itemLayoutId) {
        mItemLayoutId = itemLayoutId;
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new CommonRcvHolder(parent.getContext(), mItemLayoutId);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        //TODO 未开发完毕


    }

    public class CommonRcvHolder extends RecyclerView.ViewHolder {


        public CommonRcvHolder(Context context, int layoutId) {
            super(LayoutInflater.from(context).inflate(layoutId, null));
        }


        /**
         * 设置Item内部view的方法
         *
         * @param model    数据对象
         * @param position 当前item的position
         */
        public void setViews(CommonRcvHolder holder, T model, int position) {

            //TODO 未开发完毕
            fillData(holder, model, position);
        }

    }

    protected abstract void fillData(CommonRcvHolder holder, T model, int position);


    public void setData(List<T> data) {
        this.mData = data;
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


    public List<T> getData() {
        return mData;
    }

    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}