package com.androidex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


/**
 * RecyclerView 通用Adapter
 */
public abstract class ExRecyclerViewAdapter extends RecyclerView.Adapter<ExRecyclerViewHolder> {


    @Override
    public ExRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override public void onBindViewHolder(ExRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
