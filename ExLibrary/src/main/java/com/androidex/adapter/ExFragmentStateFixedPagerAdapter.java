package com.androidex.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.androidex.utils.LogA;

import java.util.List;

/**
 * 该适配器适用于页面较多的情况，且固定的情况下:
 * 详细注释见ExFragmentStatePagerAdapter
 */
public class ExFragmentStateFixedPagerAdapter extends FragmentStatePagerAdapter {

    private List<? extends Fragment> mFragments;
    private boolean mFragmentItemDestoryEnable = true;
    private List<String> listTitle;


    public ExFragmentStateFixedPagerAdapter(FragmentManager fragmentManager) {

        super(fragmentManager);
    }

    public ExFragmentStateFixedPagerAdapter(FragmentManager fragmentManager, List<String> listTitle) {

        super(fragmentManager);
        this.listTitle = listTitle;
    }

    public void setListTitle(List<String> listTitle) {
        this.listTitle = listTitle;
    }

    @Override public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }

    @Override public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }

    @Override public void destroyItem(ViewGroup container, int position, Object object) {

        if (LogA.isDebug()) {
            LogA.d(getClass().getSimpleName(), "~~destroyItem pos=" + position + ", fragment=" + object.hashCode() +
                    ", destory enable=" + mFragmentItemDestoryEnable);
        }

        if (mFragmentItemDestoryEnable) super.destroyItem(container, position, object);
    }

    @Override public int getCount() {

        return mFragments == null ? 0 : mFragments.size();
    }

    public void setFragments(List<? extends Fragment> fragments) {

        mFragments = fragments;
    }

    public void setFragmentItemDestoryEnable(boolean enable) {

        mFragmentItemDestoryEnable = enable;
    }

    @Override public CharSequence getPageTitle(int position) {

        if (listTitle != null) {
            return listTitle.get(position);
        }
        return super.getPageTitle(position);
    }

}
