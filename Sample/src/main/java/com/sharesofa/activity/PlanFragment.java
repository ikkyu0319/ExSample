package com.sharesofa.activity;


import android.os.Bundle;
import android.view.View;

import com.sharesofa.R;
import com.sharesofa.activity.base.BaseFragment;

/**
 * 我的行程
 */
public class PlanFragment extends BaseFragment {

    public PlanFragment() {
        // Required empty public constructor
    }



    @Override protected int setFragmentContentView() {

        return R.layout.fragment_discover;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
