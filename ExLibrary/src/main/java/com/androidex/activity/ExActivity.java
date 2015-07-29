package com.androidex.activity;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.androidex.volley.Request;
import com.androidex.volley.RequestManager;

import butterknife.ButterKnife;

/**
 *
 * ButterKnife+Volley
 */
public abstract class ExActivity extends Activity {

    private boolean mIsFirstResume = false;

    @Override public void setContentView(int layoutResId) {
        View view = getLayoutInflater().inflate(layoutResId, null);
        ButterKnife.bind(this, view);
        super.setContentView(view);
    }

    @Override public void setContentView(View view) {
        ButterKnife.bind(this, view);
        super.setContentView(view);
    }

    @Override public void setContentView(View view, ViewGroup.LayoutParams params) {
        ButterKnife.bind(this, view);
        super.setContentView(view, params);
    }


    @Override protected void onStart() {
        super.onStart();
    }

    @Override protected void onStop() {
        super.onStop();
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


    protected void onFirstResume() {


    }


    public void addRequest(Request request) {
        addRequest(request, this);
    }


    public void addRequest(Request request, Object tag) {
        request.setTag(tag);
        RequestManager.getInstance(this).addRequest(request);
    }


    public void cancelRequest(Request<?> request) {
        RequestManager.getInstance(this).cancel(request);
    }


    @Override
    public void onDestroy() {
        RequestManager.getInstance(this).cancelAll(this);
        super.onDestroy();
    }
}
