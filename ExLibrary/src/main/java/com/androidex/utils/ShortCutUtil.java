package com.androidex.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 快捷方式
 */
public class ShortCutUtil {

    private final static String TAG = ShortCutUtil.class.getName();

    /**
     * 添加快捷方式
     *
     * @param context
     * @param shortcutName name
     * @param actionIntent action
     * @param iconResource icon
     * @param allowRepeat  是否允许重复
     *                     添加权限 <uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
     */
    public static void addShortcut(Context context, String shortcutName, Intent actionIntent, Intent.ShortcutIconResource iconResource, boolean allowRepeat) {

        Intent shortcutIntent = new Intent("com.android.laucher.action.INSTALL_SHORTCUT");
        shortcutIntent.putExtra("duplicate", allowRepeat);//是否允许重复创建
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, actionIntent);
        context.sendBroadcast(shortcutIntent);
    }


    /**
     * 删除快捷方式
     *
     * @param context
     * @param shortcutName name
     * @param actionIntent action
     * @param iconResource icon
     * @param isDuplicate  是否允许循环删除重复的快捷方式
     *                     添加权限 <uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT" />
     */
    public static void deleteShortcut(Context context, String shortcutName, Intent actionIntent, Intent.ShortcutIconResource iconResource, boolean isDuplicate) {

        Intent shortcutIntent = new Intent("com.android.laucher.action.UNINSTALL_SHORTCUT");
        shortcutIntent.putExtra("duplicate", isDuplicate);//是否允许重复删除
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, actionIntent);
        context.sendBroadcast(shortcutIntent);
    }


    /**
     * 更新桌面快捷方式图标，不一定所有图标都有效<br/>
     * 如果快捷方式不存在，则不更新<br/>.
     */
    public static void updateShortcutIcon(Context context, String title, Intent intent, Bitmap bitmap) {
        if (bitmap == null) {
            LogA.i(TAG, "update shortcut icon,bitmap empty");
            return;
        }
        try {
            final ContentResolver cr = context.getContentResolver();
            StringBuilder uriStr = new StringBuilder();
            String urlTemp = "";
            String authority = LauncherUtil.getAuthorityFromPermissionDefault(context);
            if (authority == null || authority.trim().equals("")) {
                authority = LauncherUtil.getAuthorityFromPermission(context, LauncherUtil.getCurrentLauncherPackageName(context) + ".permission.READ_SETTINGS");
            }
            uriStr.append("content://");
            if (TextUtils.isEmpty(authority)) {
                int sdkInt = android.os.Build.VERSION.SDK_INT;
                if (sdkInt < 8) { // Android 2.1.x(API 7)以及以下的
                    uriStr.append("com.android.launcher.settings");
                } else if (sdkInt < 19) {// Android 4.4以下
                    uriStr.append("com.android.launcher2.settings");
                } else {// 4.4以及以上
                    uriStr.append("com.android.launcher3.settings");
                }
            } else {
                uriStr.append(authority);
            }
            urlTemp = uriStr.toString();
            uriStr.append("/favorites?notify=true");
            Uri uri = Uri.parse(uriStr.toString());
            Cursor c = cr.query(uri, new String[]{"_id", "title", "intent"},
                    "title=?  and intent=? ",
                    new String[]{title, intent.toUri(0)}, null);
            int index = -1;
            if (c != null && c.getCount() > 0) {
                c.moveToFirst();
                index = c.getInt(0);//获得图标索引
                ContentValues cv = new ContentValues();
                cv.put("icon", flattenBitmap(bitmap));
                Uri uri2 = Uri.parse(urlTemp + "/favorites/" + index + "?notify=true");
                int i = context.getContentResolver().update(uri2, cv, null, null);
                context.getContentResolver().notifyChange(uri, null);//此处不能用uri2，是个坑
                LogA.i(TAG, "update ok: affected " + i + " rows,index is" + index);
            } else {
                LogA.i(TAG, "update result failed");
            }
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LogA.i(TAG, "update shortcut icon,get errors:" + ex.getMessage());
        }
    }


    private static byte[] flattenBitmap(Bitmap bitmap) {
        // Try go guesstimate how much space the icon will take when serialized
        // to avoid unnecessary allocations/copies during the write.
        int size = bitmap.getWidth() * bitmap.getHeight() * 4;
        ByteArrayOutputStream out = new ByteArrayOutputStream(size);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
            LogA.w(TAG, "Could not write icon");
            return null;
        }
    }
}
