package com.androidex.adapter.multipletype;

/**
 * 数据Bean 需要实现此接口，这个Bean 是在list中的item
 *
 * @author tom
 */
public interface MultipleAdapterBean {

    /**
     * 得到数据的类型数
     * @return 有多少种数据的类型（item的类型）
     */
     int getDataTypeCount();

    /**
     * 返回每种数据类型的标识.<br>
     */
    Object getDataType();
}
