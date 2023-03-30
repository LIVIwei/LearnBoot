/*********************************************
 * Copyright (c) 2020 LI-ECS.
 * All rights reserved.
 * Created on 2020年1月6日
 *
 * Contributors:
 *     ECS - initial implementation
 *********************************************/

package com.example.livi.utils.DateUtil;


import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期处理工具类
 */
public class DateUtil {

    public static final FastDateFormat STANDARD_DATETIME_FORMATTER = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
    public static final FastDateFormat DEFAULT_MILLITIME_FORMATTER = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");
    public static final FastDateFormat DEFAULT_SECONDS_FORMATTER = FastDateFormat.getInstance("yyyyMMddHHmmss");
    public static final FastDateFormat DEFAULT_DATE_FORMATTER = FastDateFormat.getInstance("yyyyMMdd");
    public static final FastDateFormat DEFAULT_TIME_FORMATTER = FastDateFormat.getInstance("HHmmss");
    public static final FastDateFormat STANDARD_DATE_FORMATTER = FastDateFormat.getInstance("yyyy-MM-dd");
    private static final String DATE_FORMAT = "yyyyMMdd";
    public static final FastDateFormat MILLITIME_FORMAT = FastDateFormat.getInstance("HHmmssSSS");
    public static final FastDateFormat DATETIME_FORMATTER = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
    public static final FastDateFormat INST_DATETIME_FORMATTER = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    private static final ThreadLocal<SimpleDateFormat> sdfThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf;
        }
    };

    private static final String DEFAULT_DATE_PATTERN = "yyyyMMDD";

    private static final DateTimeFormatter DEFAULT_DTF = DateTimeFormatter.BASIC_ISO_DATE;

    private static final Map<String, DateTimeFormatter> DTF_MAP = new HashMap<>(8);

    static {
        DTF_MAP.put(DEFAULT_DATE_PATTERN, DEFAULT_DTF);
    }


    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * @return
     * @Description:获取ISODateTime
     */
    public static String getISODateTime() {
        return STANDARD_DATETIME_FORMATTER.format(new Date());
    }


    /**
     * @return
     * @Description:获取java DateTime
     */
    public static String getjavaDateTime() {
        return DATETIME_FORMATTER.format(new Date());
    }

    /**
     * @return
     * @Description:获取运营机构请求报文时间格式
     */
    public static String getInstDateTime() { return INST_DATETIME_FORMATTER.format(new Date()); }

    /**
     * @return
     * @Description: 获取日期时间精确到秒
     * 格式：yyyyMMddHHmmss
     */
    public static String formatSeconds() {
        return DEFAULT_SECONDS_FORMATTER.format(new Date());
    }

    /**
     * @param dateTime yyyyMMddHHmmss格式字符串
     * @return
     * @throws ParseException
     * @Description:获取yyyy-MM-dd'T'HH:mm:ss格式
     */
    public static String formatStandardDateTime(String dateTime) throws ParseException {
        return DEFAULT_SECONDS_FORMATTER.format(STANDARD_DATETIME_FORMATTER.parse(dateTime));
    }


    /**
     * @param dateTime yyyyMMddHHmmss格式字符串
     * @return
     * @throws ParseException
     * @Description:获取yyyyMMddHHmmss格式
     */
    public static String formatIsoDateTime(String dateTime) {
        try {
            return STANDARD_DATETIME_FORMATTER.format(DEFAULT_SECONDS_FORMATTER.parse(dateTime));
        } catch (ParseException e) {
            return getISODateTime();
        }
    }

    /**
     * @param dateTime yyyyMMddHHmmss格式字符串
     * @param dateTime
     * @return 获取yyyyMMdd格式
     */
    public static String formatDate(String dateTime) {
        try {
            return STANDARD_DATETIME_FORMATTER.format(DEFAULT_DATE_FORMATTER.parse(dateTime));
        } catch (ParseException e) {
            return getISODateTime();
        }
    }

    /**
     * @param dateTime yyyyMMddHHmmss格式字符串
     * @param dateTime
     * @return 获取HHmmss格式
     */
    public static String formatTime(String dateTime) {
        try {
            return STANDARD_DATETIME_FORMATTER.format(DEFAULT_TIME_FORMATTER.parse(dateTime));
        } catch (ParseException e) {
            return getISODateTime();
        }
    }

    /**
     * @param dateTime yyyy-MM-dd 转换为yyyyMMdd
     * @return
     * @throws ParseException
     * @Description:获取yyyyMMdd格式
     */
    public static String getDateStr(String dateTime) throws ParseException {
        return DEFAULT_DATE_FORMATTER.format(STANDARD_DATE_FORMATTER.parse(dateTime));
    }

    /**
     * @param date 为yyyyMMdd 转换 yyyy-MM-dd
     * @return
     * @throws ParseException
     * @Description:获取yyyy-MM-dd格式
     */
    public static String formatDateStr(String date) throws ParseException {
        return STANDARD_DATE_FORMATTER.format(DEFAULT_DATE_FORMATTER.parse(date));

    }

    /**
     * @return
     * @Description: 获取日期时间精确到毫秒
     * 格式：yyyyMMddHHmmssSSS
     */
    public static String formatMilliTime() {
        return DEFAULT_MILLITIME_FORMATTER.format(new Date());
    }

    /**
     * @param date
     * @return <tt>true</tt> if this date is valid
     * @// TODO: 2020/11/16  use DateTimeFormatter to replace SimpleDateFormat
     */
    public static boolean checkDate(String date) {
        SimpleDateFormat sdf = sdfThreadLocal.get();
        try {
            //设置为严格模式
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * @return
     * @Description: 获取日期
     * 格式yyyyMMdd
     */
    public static String getDefaultDate() {
        return DEFAULT_DATE_FORMATTER.format(new Date());
    }

    /**
     * @return
     * @Description: 获取时间
     * 格式HHmmss
     */
    public static String getDefaultTime() {
        return DEFAULT_TIME_FORMATTER.format(new Date());
    }

    /**
     * @return
     * @Description: 获取时间
     * 格式HHmmssSSS
     */
    public static String getDefaultTimeSSS() {
        return MILLITIME_FORMAT.format(new Date());
    }

    /**
     * @return
     * @Description: 获取yyyyMMdd格式
     * 格式：yyyyMMdd
     */
    public static String getSysDate() {
        return DEFAULT_DATE_FORMATTER.format(new Date());
    }

    /**
     * @return
     * @Description: 获取yyyyMMddHHmmss格式
     * 格式：yyyyMMddHHmmss
     */
    public static String getSysTime() {
        return DEFAULT_SECONDS_FORMATTER.format(new Date());
    }

    /**
     * @return
     * @Description: 获取yyyyMMddHHmmss格式
     * 格式：yyyyMMddHHmmss
     */
    public static String getSystemTime() {
        return System.currentTimeMillis() + "";
    }

    /**
     * 获取当前月份
     *
     * @return current month
     */
    public static String getCurMonth() {
        return String.valueOf(LocalDate.now().getMonthValue());
    }

    /**
     * 获取当前日
     *
     * @return current day of month
     */
    public static String getCurDay() {
        return String.valueOf(LocalDate.now().getDayOfMonth());
    }

    /**
     * 获取当前时间
     *
     * @return pattern of hh:mm:ss
     */
    public static String getCurTime() {
        String curTime = getISODateTime();
        return curTime.substring(curTime.length() - 8);
    }

    /**
     * 时间：2021-01-14T09:24:01转 20210114092401
     *
     * @param strISODate
     * @return
     */
    public static String formatISODateTimeToDate(String strISODate) {
        try {
            return DEFAULT_SECONDS_FORMATTER.format(STANDARD_DATETIME_FORMATTER.parse(strISODate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param date   当前时间
     * @param amount 增加小时数
     * @return 增加后时间
     * @description 增加小时
     */
    public static Date addHours(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    /**
     * @Description:获取带毫秒时间
     * 格式HHmmssSSS
     */
    public static String getMilliTimeFromDate(Date date) { return MILLITIME_FORMAT.format(date); }


    /**
     * @return
     * @Description: 获取时间
     * 格式HHmmss
     */
    public static String getDefaultTimeFromDate(Date date) {
        return DEFAULT_TIME_FORMATTER.format(date);
    }

    /**
     * @return
     * @Description: 指公元1970年1月1日0时0分0秒算起至今的北京时间所经过的秒数。
     * 北京时间比格林尼治时间（世界时）早8小时，即：北京时间=世界时+8小时。
     * 格式HHmmss
     */
    public static String getCurTimeSeconds() {
        return String.valueOf(new Date().getTime() / 1000);
    }

    public static long getRemainSecondsOneDay(Date currentDate) {
        Calendar midNight = Calendar.getInstance();
        //      midNight.setTime(currentDate);
        midNight.add(Calendar.DAY_OF_MONTH, 1);
        midNight.set(Calendar.HOUR_OF_DAY, 0);
        midNight.set(Calendar.MINUTE, 0);
        midNight.set(Calendar.SECOND, 0);
        midNight.set(Calendar.MILLISECOND, 0);
        long seconds = (long) ((midNight.getTime().getTime() - currentDate.getTime()) / 1000);
        return seconds;
    }

    public static boolean isTimeOut(String msgSendTime,String authMsgCtive){
        boolean isTimeout = false;
        try {
            long interval = (DEFAULT_SECONDS_FORMATTER.parse(formatSeconds()).getTime() - DEFAULT_SECONDS_FORMATTER.parse(msgSendTime).getTime())/1000;
//            long interval_end = Long.parseLong(authMsgCtive)*60;
            long interval_end = Long.parseLong(authMsgCtive);
            if(interval-interval_end>=0){
                isTimeout = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            isTimeout = true;
        }
        return isTimeout;
    }


    /**
     * 根据特定格式格式化日期
     *
     * @param date   被格式化的日期
     * @param format 日期格式，常用格式见： {@link cn.hutool.core.date.DatePattern}
     * @return 格式化后的字符串
     */
    public static String format(Date date, String format) {
        if (null == date || StrUtil.isBlank(format)) {
            return null;
        }

        return FastDateFormat.getInstance(format).format(date);
    }

    public static Date parseDate(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        Date date = null;
        try {
            date = DEFAULT_DATE_FORMATTER.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
