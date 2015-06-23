package com.androidex.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串帮助类
 */
public class TextUtils {


    /**
     * 判断字符串为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {

        if (str == null || str.trim().length() == 0)
            return true;
        else
            return false;
    }

    /**
     * 判断字符串不为空
     *
     * @param str
     * @return
     */
    public static boolean isNoEmpty(String str) {
        return !isEmpty(str);
    }


    /**
     * 判断str是否是数字组成的
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {

        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }


    /**
     * 是否是邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkMailFormat(String email) {

        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.find();
    }


}
