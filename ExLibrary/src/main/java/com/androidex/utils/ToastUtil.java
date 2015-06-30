package com.androidex.utils;

import android.widget.Toast;

import com.androidex.context.ExApplication;

/**
 * Toast
 */
public class ToastUtil {

	private static Toast mToast = Toast.makeText(ExApplication.getContext(), "", Toast.LENGTH_LONG);
	
    public static void showToast(int rid)
    {
    	mToast.setText(rid);
    	mToast.show();
    }
    
    public static void showToast(String text)
    {
    	mToast.setText(text);
    	mToast.show();
    }
    
    public static void showToast(int rid, Object... args){
    	
    	showToast(ExApplication.getContext().getResources().getString(rid, args));
    }
}
