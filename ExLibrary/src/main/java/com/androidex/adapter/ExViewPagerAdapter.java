package com.androidex.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tom on 15/6/12.
 */
public class ExViewPagerAdapter extends PagerAdapter {


    @Override public int getCount() {
        return 0;
    }

    @Override public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }


}
