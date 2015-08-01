package com.sharesofa.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.androidex.adapter.singletype.ExCommonLvAdapter;
import com.androidex.adapter.singletype.ExCommonRcvAdapter;
import com.androidex.adapter.singletype.ExViewHolder;
import com.sharesofa.R;
import com.sharesofa.bean.Users;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Users> list = new ArrayList<>();
        RecyclerView mRecyclerView = null;
        if (mRecyclerView != null)
            mRecyclerView.setAdapter(new ExCommonRcvAdapter<Users>(list, android.R.layout.simple_list_item_1) {
                @Override
                protected void fillData(CommonRcvHolder holder, Users model, int position) {
                    //TODO ExCommonRcvAdapter未开发完毕
                }
            });


        ListView mListView = null;

        if (mListView != null)
            mListView.setAdapter(new ExCommonLvAdapter<Users>(this, list, android.R.layout.simple_list_item_1) {
                @Override public void convert(ExViewHolder holder, Users bean) {


                }
            });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
