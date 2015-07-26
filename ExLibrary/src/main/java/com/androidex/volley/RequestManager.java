package com.androidex.volley;

import android.content.Context;

import com.androidex.volley.toolbox.Volley;

/**
 * Created by tom on 15/7/27.
 */
public class RequestManager {

    private static RequestManager sInstance;

    public static RequestManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (RequestManager.class) {
                if (sInstance == null) {
                    sInstance = new RequestManager(context);
                }
            }
        }
        return sInstance;
    }


    private RequestQueue mRequestQueue;


    private RequestManager(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }


    public void addRequest(Request request) {
        mRequestQueue.add(request);
    }


    public void cancelAll(Object tag) {
        mRequestQueue.cancelAll(tag);
    }


    public void cancel(final Request<?> request) {
        mRequestQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> r) {
                return r.equals(request);
            }
        });
    }
}
