
package com.androidex.volley.request;

import com.androidex.volley.NetworkResponse;
import com.androidex.volley.Request;
import com.androidex.volley.Request.Method;
import com.androidex.volley.Response;
import com.androidex.volley.Response.Listener;
import com.androidex.volley.toolbox.HttpHeaderParser;

public class ByteRequest extends Request<byte[]> {
    private final Listener<byte[]> mListener;

    /**
     * Creates a new GET request.
     *
     * @param url URL to fetch the string at
     * @param listener Listener to receive the byte array response
     */
    public ByteRequest(String url, Listener<byte[]> listener,
                       Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the byte array at
     * @param listener Listener to receive the byte array response or error message
     */
    public ByteRequest(int method, String url, Listener<byte[]> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mListener = listener;
    }

    @Override
    protected void deliverResponse(byte[] response) {
        if(null != mListener){
            mListener.onResponse(response);
        }
    }

    @Override
    protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {
        return Response.success(response.data, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    public String getBodyContentType() {
        return "application/octet-stream";
    }
}