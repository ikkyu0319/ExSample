/**
 * Copyright (c) 2004, qyer.com, Inc. All rights reserved.
 */
package com.androidex.view.pop;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.androidex.utils.ViewUtil;

/**
 * 内置ListView的popwindow
 *
 * @see android.support.v7.widget.PopupMenu  更推荐使用PopupMenu
 */
public class ExListPopWindow extends ExPopWindow {

    private ListView mLvData;
    private BaseAdapter mAdapter;

    public ExListPopWindow(Context context, BaseAdapter adapter) {

        super(context);
        mAdapter = adapter;
        initContentView(context);
    }

    private void initContentView(Context context) {

        mLvData = ViewUtil.getCleanListView(context, 1);
        mLvData.setAdapter(mAdapter);
        setContentView(mLvData);
    }

    public ListView getListView() {

        return mLvData;
    }

    public void notifyDataSetChanged() {

        mAdapter.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {

        mAdapter.notifyDataSetInvalidated();
    }
}
