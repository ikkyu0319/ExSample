package com.androidex.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.androidex.volley.Request;
import com.androidex.volley.RequestManager;

import butterknife.ButterKnife;


public abstract class ExFragment extends Fragment {

    private boolean mIsFirstResume = false;
    private FrameLayout mFrameView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mFrameView = onCreateFragmentFrameView();
        return mFrameView;
    }

    protected FrameLayout onCreateFragmentFrameView() {

        return new FrameLayout(getActivity());
    }

    protected void setFragmentContentView(int layoutResId) {

        setFragmentContentView(getActivity().getLayoutInflater().inflate(layoutResId, null));
    }

    protected void setFragmentContentView(View view) {

        mFrameView.addView(view, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        ButterKnife.bind(this, view);

        initData();
        initContentView();
    }


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

    protected abstract void initData();

    protected abstract void initContentView();



    @Override
    public void onResume() {
        super.onResume();
        if (!mIsFirstResume) {
            mIsFirstResume = true;
        } else {
            onFirstResume();
        }
    }


    protected void onFirstResume() {


    }


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

//    @Override public void onStart() {
//        super.onStart();
//        //注册EventBus
//        EventBus.getDefault().register(this);
//    }
//
//    @Override public void onStop() {
//        super.onStop();
//        //取消EventBus
//        EventBus.getDefault().unregister(this);
//    }



}
