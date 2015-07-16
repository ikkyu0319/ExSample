package com.androidex.utils;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期Util
 */
public class DateUtil {

  public static final String DATE_FORMAT_SIMPLE = "yyyy-MM-dd";
  public static final String DATE_FORMAT_DETAIL = "yyyy-MM-dd HH:mm:ss"; // 24h
  public static final String DATE_FORMAT_DETAIL_2 = "yyyy-MM-dd hh:mm:ss"; // 12h

  public static String getFormatTime(long timeInMillis, SimpleDateFormat dateFormat) {
    return dateFormat.format(new Date(timeInMillis));
  }

  public static String getSimpleTime(long timeInMillis) {
    return DateFormat.format(DATE_FORMAT_SIMPLE, timeInMillis).toString();
  }

  public static String getDetailTime24(long timeInMillis) {
    return DateFormat.format(DATE_FORMAT_DETAIL, timeInMillis).toString();
  }

  public static String getDetailTime12(long timeInMillis) {
    return DateFormat.format(DATE_FORMAT_DETAIL_2, timeInMillis).toString();
  }

  /**
   * 返回当前时间，单位秒
   */
  public static long getCurrentTimeInLong() {
    return System.currentTimeMillis();
  }

  /**
   * 返回当前日期 格式：yyyy-MM-dd";
   */
  public static String getCurrentSimeTime() {
    return getSimpleTime(System.currentTimeMillis());
  }

  /**
   * 返回当前时间 格式：yyyy-MM-dd HH:mm:ss";
   */
  public static String getCurrentDetailTime24() {
    return getDetailTime24(System.currentTimeMillis());
  }
  /**
   * 获取自定义格式的日期
   *
   * @param mark eg：yyyyMMddHHmmss yyyy年MM月dd日 HH时mm分ss秒
   */
  public static String getMyFormatDate(String mark) throws Exception {

    return new SimpleDateFormat(mark).format(new Date());
  }

  /**
   * 获取自定义格式的日期
   *
   * @param mark 自定义的格式 ：yyyy/MM/dd
   * @param uTime Unix 时间戳
   */
  public static String getFormatDateByCustomMarkAndUnixTime(String mark, long uTime) {

    return new SimpleDateFormat(mark).format(new Date(uTime * 1000));
  }
}
