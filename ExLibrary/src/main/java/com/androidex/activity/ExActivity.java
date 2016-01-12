package com.androidex.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.androidex.volley.Request;
import com.androidex.volley.RequestManager;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;


/**
 * ExActivity  无Toolbar
 * <p>
 * ButterKnife+Volley+EventBus
 */
public abstract class ExActivity extends AppCompatActivity {


    private Fragment mCurrentFragment;
    private boolean mIsFirstResume = false;

    /**
     * ++++++++++++++++++++++++++Toolbar part++++++++++++++++++++++++++
     */

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

//        initData();
//        initContentView();
    }
//    protected abstract void initData();
//    protected abstract void initContentView();

    /**
     * ++++++++++++++++++++++++++fragment activity part++++++++++++++++++++++++++
     */
    protected void addFragment(int frameId, Fragment f) {

        if (f == null) return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().beginTransaction().add(frameId, f).commit();
    }

    protected void addFragment(int frameId, Fragment f, String tag) {

        if (f == null) return;

        getSupportFragmentManager().beginTransaction().add(frameId, f, tag).commit();
    }

    /**
     * 带动画效果的
     */
    protected void addFragmentWithAnimation(int frameId, Fragment f, int animIn, int animOut) {

        if (f == null) return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(animIn, animOut);
        transaction.add(frameId, f).commit();
    }

    protected void addFragmentWithAnimation(int frameId, Fragment f, String tag, int animIn,
                                            int animOut) {

        if (f == null) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(animIn, animOut);
        transaction.add(frameId, f, tag).commit();
    }

    protected Fragment findFragmentByTag(String tag) {

        if (tag == null) return null;

        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    protected void replaceFragment(int frameId, Fragment f) {

        if (f == null) return;

        getSupportFragmentManager().beginTransaction().replace(frameId, f);
    }

    /**
     * 推荐使用
     */
    protected void switchFragment(Fragment f) {
        if (f == null) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(f);
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        transaction.commit();
        mCurrentFragment = f;
    }


    @Override protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!mIsFirstResume) {
            mIsFirstResume = true;
        } else {
            onFirstResume();
        }
    }


    protected void onFirstResume() {

    }


    /**
     * Volley Part
     * @param request
     */
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
    protected void onDestroy() {
        RequestManager.getInstance(this).cancelAll(this);
        super.onDestroy();
    }
}
