package com.sharesofa.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.androidex.adapter.singletype.ExCommonLvAdapter;
import com.androidex.adapter.singletype.ExCommonRcvAdapter;
import com.androidex.adapter.ExLvViewHolder;
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
                @Override public void convert(ExLvViewHolder holder, Users bean) {


                }
            });


    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
