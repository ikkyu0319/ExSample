package com.androidex.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;


public class ExFragment extends Fragment {


    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }
}
