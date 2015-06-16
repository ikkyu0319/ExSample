package com.androidex.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;


public abstract class ExFragment extends Fragment {

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
        ButterKnife.inject(this, view);

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
        ButterKnife.reset(this);
    }

    protected abstract void initData();

    protected abstract void initContentView();

}
