package com.androidex.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;


public class ExActionBarActivity extends ActionBarActivity {

    private Fragment mCurrentFragment;


    /**
     * ++++++++++++++++++++++++++fragment activity part++++++++++++++++++++++++++
     */
    protected void addFragment(int frameId, Fragment f) {

        if (f == null)
            return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().beginTransaction().add(frameId, f).commit();
    }

    protected void addFragment(int frameId, Fragment f, String tag) {

        if (f == null)
            return;

        getSupportFragmentManager().beginTransaction().add(frameId, f, tag).commit();
    }

    /**
     * 带动画效果的
     *
     * @param frameId
     * @param f
     * @param animIn
     * @param animOut
     */
    protected void addFragmentWithAnimation(int frameId, Fragment f, int animIn, int animOut) {

        if (f == null)
            return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(animIn, animOut);
        transaction.add(frameId, f).commit();
    }

    protected void addFragmentWithAnimation(int frameId, Fragment f, String tag, int animIn, int animOut) {

        if (f == null)
            return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(animIn, animOut);
        transaction.add(frameId, f, tag).commit();
    }

    protected Fragment findFragmentByTag(String tag) {

        if (tag == null)
            return null;

        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    protected void replaceFragment(int frameId, Fragment f) {

        if (f == null)
            return;

        getSupportFragmentManager().beginTransaction().replace(frameId, f);
    }

    /**
     * 推荐使用
     *
     * @param f
     */
    protected void switchFragment(Fragment f) {
        if (f == null)
            return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(f);
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        transaction.commit();
        mCurrentFragment = f;
    }


}
