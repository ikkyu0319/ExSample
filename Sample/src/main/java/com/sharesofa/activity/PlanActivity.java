package com.sharesofa.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.sharesofa.R;
import com.sharesofa.activity.base.BaseActivity;

import butterknife.Bind;


public class PlanActivity extends BaseActivity {


    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_plan);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_plan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        switch (id) {
            case R.id.action_notification:

                break;
            case R.id.action_create:

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
