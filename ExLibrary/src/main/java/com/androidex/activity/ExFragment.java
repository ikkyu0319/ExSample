package com.androidex.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidex.volley.Request;
import com.androidex.volley.RequestManager;

import org.greenrobot.eventbus.EventBus;



/**
 * Fragment
 * <p>
 * 1、add(), show(), hide(), replace()
 * * * show()，hide()最终是让Fragment的View setVisibility(true还是false)，不会调用生命周期；
 * * * replace()的话会销毁视图，即调用onDestoryView、onCreateView等一系列生命周期；
 * <p>
 * <p>
 * <p>
 * ButterKnife+Volley+EventBus
 */
public abstract class ExFragment extends Fragment {

    private boolean mIsFirstResume = false;
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(setFragmentContentView(), container, false);


        return mRootView;
    }


    /**
     * 子布局 XML
     *
     * @return
     */
    protected abstract int setFragmentContentView();


    @Override public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }


    @Override public void onDestroyView() {
        super.onDestroy();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (!mIsFirstResume) {
            mIsFirstResume = true;
        } else {
            onFirstResume();
        }
    }

    /**
     * First onResume
     */
    protected void onFirstResume() {


    }


    @Override public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        setHasOptionsMenu(true);
    }

    @Override public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    protected void addFragment(int frameId, Fragment f) {

        if (f == null) return;
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        getChildFragmentManager().beginTransaction().add(frameId, f).commit();
    }

    protected void addFragment(int frameId, Fragment f, String tag) {

        if (f == null) return;

        getChildFragmentManager().beginTransaction().add(frameId, f, tag).commit();
    }

    protected Fragment findFragmentByTag(String tag) {

        if (tag == null) return null;

        return getChildFragmentManager().findFragmentByTag(tag);
    }

    protected void replaceFragment(int frameId, Fragment f) {

        if (f == null) return;

        getChildFragmentManager().beginTransaction().replace(frameId, f);
    }

    /**
     * Volley part
     *
     * @param request
     */
    public void addRequest(Request request) {
        addRequest(request, this);
    }


    public void addRequest(Request request, Object tag) {
        request.setTag(tag);
        RequestManager.getInstance(getActivity()).addRequest(request);
    }


    public void cancelRequest(Request<?> request) {
        RequestManager.getInstance(getActivity()).cancel(request);
    }


    @Override
    public void onDestroy() {
        RequestManager.getInstance(getActivity()).cancelAll(this);
        super.onDestroy();
    }


}
