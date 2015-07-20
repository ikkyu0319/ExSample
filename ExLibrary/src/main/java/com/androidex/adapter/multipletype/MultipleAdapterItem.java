package com.androidex.adapter.multipletype;

import android.support.annotation.LayoutRes;

import com.androidex.adapter.singletype.ExViewHolder;


/**
 * adapter的所有item必须实现此接口.
 * 通过返回layoutResId来自动初始化view，之后在initView中就可以初始化item的内部视图了。<br>
 *
 * @author Tom
 */
public interface MultipleAdapterItem<T extends MultipleAdapterBean> {

    /**
     * 返回item的布局文件id
     *
     * @return layout的id
     */
    @LayoutRes
    public int getLayoutResId();

    /**
     * 根据数据来初始化item的内部view
     *
     * @param vh       view holder
     * @param model    数据list内部的model
     * @param position 当前adapter调用item的位置
     */
    public void initViews(ExViewHolder vh, T model, int position);

}  