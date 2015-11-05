package com.androidex.utils;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author tom
 */
public class TimeUtil {

    public static int min = 1000 * 60;
    public static int hour = 1000 * 60 * 60;
    public static int day = 1000 * 60 * 60 * 24;

    /**
     * 统一的时间戳格式化，APP的时间戳都按这个规则来
     *
     * @param currentTimes
     * @return
     */
    public static CharSequence getCommonTimeFormatText(long currentTimes) {

        long temp = System.currentTimeMillis() - currentTimes;

        if (temp < min) {

            return temp / 1000 + "秒前";
        } else if (temp < hour) {

            return temp / min + "分钟前";
        } else if (temp < day) {

            return temp / hour + "小时前";
        } else if (temp < (7 * day)) {

            return temp / day + "天前";
        } else {

            return DateFormat.format("yyyy-MM-dd", currentTimes);
        }
    }

    /**
     * 日历转换成固定格式的形式返回yyyy年MM月dd日
     *
     * @param calendar
     * @return
     */
    public static String getCalendarTimeToString(Calendar calendar) {
        if (calendar == null) {
            return TextUtils.TEXT_EMPTY;
        }

        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }

    /**
     * 日历转换成固定格式的形式返回yyyy-MM-dd
     *
     * @param calendar
     * @return
     */
    public static String getTimeWithoutChinaToString(Calendar calendar) {
        if (calendar == null) {
            return TextUtils.TEXT_EMPTY;
        }

        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 计算2个Calendar对象之间相差多少天
     *
     * @param startCalendar
     * @param endCalendar
     * @return
     */
    public static int getDaysBettweenCalendar(Calendar startCalendar, Calendar endCalendar) {
        if (startCalendar == null || endCalendar == null) {
            return 0;
        }

        long time = endCalendar.getTimeInMillis() - startCalendar.getTimeInMillis();
        int days = new Long(time / day).intValue();

        return days;
    }

    //获取明天和后天的long
    //[0] 明天
    //[1]后天
    public static long[] get2Day() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        long begin = calendar.getTime().getTime();
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        long end = calendar.getTime().getTime();
        return new long[]{begin, end};
    }


    /**
     * 返回 文字格式化（周中的天数）
     *
     * @param timeMillis
     * @return
     */
    public static String getDayWeek(long timeMillis) {

        long timeNowMillis = System.currentTimeMillis();

        if (Math.abs(timeNowMillis - timeMillis) < day && timeMillis < timeNowMillis) {
            return "今天";
        }
        if ((timeMillis - timeNowMillis) < day && timeMillis > timeNowMillis) {
            return "明天";
        } else if ((timeMillis - timeNowMillis) < day * 2 && timeMillis > timeNowMillis) {
            return "后天";
        }

        //TODO 昨天 前天

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
        String date = simpleDateFormat.format(new Date(timeMillis));

        return date;
    }


}
