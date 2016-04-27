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
public class TimeUtil extends DateUtil {

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
//        else if (Math.abs(timeMillis - timeNowMillis) < day && (timeMillis < timeNowMillis)) {
//            return "昨天";
//        } else if (Math.abs(timeMillis - timeNowMillis) < day * 2 && timeMillis < timeNowMillis) {
//            return "前天";
//        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
        String date = simpleDateFormat.format(new Date(timeMillis));

        return date;
    }


    /**
     * 判断时间
     *
     * @param time 秒
     * @return
     */
    public static String formatDateTime(long time) {

        if (time == 0 || "".equals(time)) {
            return "";
        }
        Date date = new Date(1000 * time);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_DETAIL);
        String datetime = format.format(date); //时间的 字符串

        Calendar current = Calendar.getInstance();
        Calendar today = Calendar.getInstance(); // 今天
        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        // Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        Calendar yesterday = Calendar.getInstance(); // 昨天
        yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        yesterday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) - 1);
        yesterday.set(Calendar.HOUR_OF_DAY, 0);
        yesterday.set(Calendar.MINUTE, 0);
        yesterday.set(Calendar.SECOND, 0);

        Calendar mintianday = Calendar.getInstance(); // 明天
        mintianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        mintianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        mintianday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) + 1);
        mintianday.set(Calendar.HOUR_OF_DAY, 0);
        mintianday.set(Calendar.MINUTE, 0);
        mintianday.set(Calendar.SECOND, 0);

        Calendar houtianday = Calendar.getInstance(); // 后天
        houtianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        houtianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        houtianday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) + 2);
        houtianday.set(Calendar.HOUR_OF_DAY, 0);
        houtianday.set(Calendar.MINUTE, 0);
        houtianday.set(Calendar.SECOND, 0);

        Calendar dahoutianday = Calendar.getInstance(); // 大后天
        dahoutianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        dahoutianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        dahoutianday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) + 3);
        dahoutianday.set(Calendar.HOUR_OF_DAY, 0);
        dahoutianday.set(Calendar.MINUTE, 0);
        dahoutianday.set(Calendar.SECOND, 0);

        current.setTime(date);

        if (current.after(today) && current.before(mintianday)) {

            return "今天 " + datetime.split(" ")[1];
        } else if (current.before(today) && current.after(yesterday)) {

            return "昨天 " + datetime.split(" ")[1];
        } else if (current.after(mintianday) && current.before(houtianday)) {

            return "明天 " + datetime.split(" ")[1];
        } else if (current.after(houtianday) && current.before(dahoutianday)) {

            return "后天 " + datetime.split(" ")[1];
        } else {

            int index = datetime.indexOf("-") + 1;
            return datetime.substring(index, datetime.length());
        }
    }

}
