package com.androidex.activity;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class ExActivity extends Activity {


    private boolean isEventBus = false;

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


}
