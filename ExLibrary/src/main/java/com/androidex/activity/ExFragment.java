package com.androidex.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidex.volley.Request;
import com.androidex.volley.RequestManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;


/**
 * Fragment
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

        ButterKnife.bind(this, mRootView);
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
        ButterKnife.unbind(this);
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


    /**
     * Volley part
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
