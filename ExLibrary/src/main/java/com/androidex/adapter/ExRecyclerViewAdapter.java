package com.androidex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


/**
 * RecyclerView 通用Adapter
 */
public class ExRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
