package com.androidex.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.androidex.utils.LogA;

import java.util.List;

/**
 * 该适配器适用于页面较少，且只有固定几个的情况:
 * 详细说明见ExFragmentPagerAdapter注释
 */
public class ExFragmentFixedPagerAdapter extends FragmentPagerAdapter {

    private List<? extends Fragment> mFragments;
    private boolean mFragmentItemDestoryEnable = true;

    public ExFragmentFixedPagerAdapter(FragmentManager fragmentManager) {

        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if (LogA.isDebug())
            LogA.d(getClass().getSimpleName(), "~~destroyItem pos=" + position + ", fragment=" + object.hashCode() +
                    ", destory enable=" + mFragmentItemDestoryEnable);

        if (mFragmentItemDestoryEnable)
            super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {

        return mFragments == null ? 0 : mFragments.size();
    }

    public void setFragments(List<? extends Fragment> fragments) {

        mFragments = fragments;
    }

    public void setFragmentItemDestoryEnable(boolean enable) {

        mFragmentItemDestoryEnable = enable;
    }

    /**
     * 该方法已被弃用
     */
    @Override
    public void destroyItem(View container, int position, Object object) {

        if (mFragmentItemDestoryEnable)
            super.destroyItem(container, position, object);
    }

    /**
     * 该方法已被弃用
     */
    @Override
    public Object instantiateItem(View container, int position) {

        return super.instantiateItem(container, position);
    }
}
