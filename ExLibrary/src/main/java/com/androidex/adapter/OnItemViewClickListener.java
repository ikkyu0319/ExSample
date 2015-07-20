package com.androidex.adapter;

import android.view.View;


/**
 * Lv & Rv  Item onClick 事件
 * @param <T>
 */
public interface OnItemViewClickListener<T> {
	
	public void onViewClick(int position,T t, View view);
}
