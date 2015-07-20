package com.androidex.adapter;

import android.view.View;


/**
 * Lv & Rv  Item onClick 事件
 * @param <T>
 */
public interface OnItemViewLongClickListener<T> {
	
	public void onViewLongClick(int position,T t, View view);
}
