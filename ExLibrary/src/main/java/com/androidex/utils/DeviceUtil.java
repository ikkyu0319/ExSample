package com.androidex.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;

import com.androidex.context.ExApplication;

public class DeviceUtil {



	public static boolean hasApp(String packageName) {

		if(packageName == null || packageName.length() == 0)
			return false;

		PackageInfo packageInfo = null;
		try {

			packageInfo = ExApplication.getContext().getPackageManager().getPackageInfo(packageName, 0);

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		return packageInfo == null ? false : true;
	}





	public static boolean hasSinaWeiboClient() {
		try {

			PackageInfo packageInfo = ExApplication.getContext().getPackageManager().getPackageInfo("com.sina.weibo", 0);
			if (packageInfo == null)
				return false;

			int highBit = packageInfo.versionName.charAt(0);
			return highBit > 50 ? true : false;// 50 = 2

		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * 判断是否有电话功能
	 * @return
	 * true:有电话功能
	 * false:没有电话功能
	 */
	public static boolean hasPhone() {

		TelephonyManager telephony = (TelephonyManager) ExApplication.getContext().
														getSystemService(Context.TELEPHONY_SERVICE);
		return telephony.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE ? false : true;
	}
}
