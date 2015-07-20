package com.sharesofa;

import android.content.res.Configuration;

import com.androidex.context.ExApplication;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.sharesofa.config.ImagePipelineConfigFactory;


/**
 * Created by tom on 15/5/16.
 */
public class SampleApplication extends ExApplication {


    @Override public void onCreate() {
        super.onCreate();

        
        Fresco.initialize(getContext(), ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this));

    }

    @Override public void onLowMemory() {
        super.onLowMemory();
    }

    @Override public void onTerminate() {
        super.onTerminate();
    }

    @Override public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }


    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


}
