package com.sharesofa.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androidex.activity.ExAppCompatActivity;

/**
 * 1.show MainView
 * 2.show TripView(EmptyView&NetErrorView ..)
 *
 * @author tom
 */
public abstract class BaseActivity<T> extends ExAppCompatActivity {


    private View mEmptyView;
    private View mConvertView;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }






}
