package com.androidex.adapter;

import android.view.View;

public interface OnItemViewLongClickListener<T> {
	
	public void onViewLongClick(int position,T t, View view);
}
