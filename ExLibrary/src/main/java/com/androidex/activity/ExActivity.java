package com.androidex.activity;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class ExActivity extends Activity {


    @Override public void setContentView(int layoutResId) {
        View view = getLayoutInflater().inflate(layoutResId, null);
        ButterKnife.inject(this, view);
        super.setContentView(view);
    }

    @Override public void setContentView(View view) {
        ButterKnife.inject(this, view);
        super.setContentView(view);
    }

    @Override public void setContentView(View view, ViewGroup.LayoutParams params) {
        ButterKnife.inject(this, view);
        super.setContentView(view, params);
    }


}
