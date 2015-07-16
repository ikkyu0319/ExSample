package com.androidex.adapter;

import android.view.View;

public interface OnItemViewClickListener<T> {
	
	public void onViewClick(int position,T t, View view);
}
