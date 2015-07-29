package com.androidex.volley;

import android.content.Context;
import android.text.TextUtils;

import com.androidex.volley.toolbox.Volley;

/**
 * Init Voley RequestQueus
 */
public class RequestManager {

    private static RequestManager sInstance;
    /**
     * Global request queue for Volley
     */
    private RequestQueue mRequestQueue;

    public static final String TAG = "ExVolleyPatterns";


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


    

    /**
     * Adds the specified request to the global queue, if tag is specified then
     * it is used else Default TAG is used.
     *
     * @param req
     * @param tag
     */
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        mRequestQueue.add(req);
    }

    /**
     * Adds the specified request to the global queue using the Default TAG.
     *
     * @param req
     * @param tag
     */
    public <T> void addToRequestQueue(Request<T> req) {
        // set the default tag if tag is empty
        req.setTag(TAG);
        mRequestQueue.add(req);
    }

    /**
     * Cancels all pending requests by the specified TAG, it is important to
     * specify a TAG so that the pending/ongoing requests can be cancelled.
     *
     * @param tag
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
