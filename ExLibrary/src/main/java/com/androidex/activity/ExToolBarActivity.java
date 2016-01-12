package com.androidex.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.Toolbar;


/**
 * ToolbarActivity  带有toolbar activity
 * <p>
 * ButterKnife+Volley+EventBus
 */
public abstract class ExToolBarActivity extends ExActivity {


    private Toolbar mToolbar;

    /**
     * ++++++++++++++++++++++++++Toolbar part++++++++++++++++++++++++++
     */
    @Override public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


}
