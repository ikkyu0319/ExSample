package com.androidex.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.androidex.utils.LogA;

import java.util.List;

/**
 * 该适配器适用于页面较少的情况:
 * 当第一次加载position对应的Fragment时，首先getItem()创建Fragment对象，并缓存起来，再走生命周期:onCreateView -> onActivityCreate() -> onStart()
 * 当要销毁时adapter回调destoryItem：
 * 如果destoryItem正常完成，此时Fragment的生命周期是:onStop() -> onDestoryView()，但并没有销毁Fragment对象；
 * 如果destoryItem未正常完成，则什么都不做;
 * <p>
 * 当需要再次使用的时候，通过instantiateItem()，获取缓存Fragment：
 * 如果之前正常destoryItem，不会再getItem()创建Fragment对象，直接走缓存的Fragment对象的onCreateView -> onActivityCreate() -> onStart
 * 去过之前destoryItem未正常完成，则继续使用缓存的Fragment，且什么都不做
 * <p>
 * 当调用NotifyDataSetChanged时，如果getItemPosition()返回POSITION_NONE时,
 * adapter会调用回调instantiateItem()，获取对应的缓存Fragment，回调 destoryItem：
 * 如果destoryItem正常完成，此时Fragment的生命周期是:onStop() -> onDestoryView()，
 * 然后再 onCreateView -> onActivityCreate -> onStart()；
 * <p>
 * 如果destoryItem未正常完成：则什么都不做
 * <p>
 * # destoryItem 正常与未正常指的是真正调用了父类的destoryItem方法
 */
public abstract class ExFragmentPagerAdapter<T> extends FragmentPagerAdapter {

    private List<T> mData;
    private FragmentActivity mFragmentActivity;
    private boolean mFragmentItemDataSetChangedEnable;
    private boolean mFragmentItemDestoryEnable = true;

    public ExFragmentPagerAdapter(FragmentActivity activity) {

        super(activity.getSupportFragmentManager());
        mFragmentActivity = activity;
    }

    @Override
    public int getItemPosition(Object object) {

        if (LogA.isDebug())
            LogA.d(getClass().getSimpleName(), "~~getItemPosition, obj = " + object.hashCode());

        return mFragmentItemDataSetChangedEnable ? POSITION_NONE : POSITION_UNCHANGED;
        //return super.getItemPosition(object);
        //POSITION_UNCHANGED super 默认实现返回的是该值，
        //调用notifyDataSetChanged是不会回调getItem等方法进行刷新的，这里返回NONE表示item需要更新
    }

    @Override
    public Fragment getItem(int position) {

        return createFragment(mFragmentActivity, position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        invalidateFragment(fragment, position);
        return fragment;
    }

    protected abstract Fragment createFragment(FragmentActivity activity, int position);

    protected abstract void invalidateFragment(Fragment fragment, int position);

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

        return mData == null ? 0 : mData.size();
    }

    public void setData(List<T> data) {

        mData = data;
    }

    public T getDataItem(int position) {

        if (mData == null)
            return null;

        T t = null;
        try {

            t = mData.get(position);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return t;
    }

    public void setFragmentItemDataSetChangedEnable(boolean enable) {

        mFragmentItemDataSetChangedEnable = enable;
    }

    public void setFragmentItemDestoryEnable(boolean enable) {

        mFragmentItemDestoryEnable = enable;
    }
}
