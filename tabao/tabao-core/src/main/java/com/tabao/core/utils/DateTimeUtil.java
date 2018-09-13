package com.tabao.core.utils;

/**
 * <p>Title: 日期类型转换处理模块</p>
 * <p>Description: 用于日期数据类型转换处理</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: 联信永益</p>
 * 
 * @author 宁郅杰
 * @version 1.0
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.util.Calendar;

public class DateTimeUtil
{

    public static final String YYYY_MM_DD_HH_MM_SS_PATTERN = "yyyy-MM-dd HH:mm";

    public static final String YYYY_MM_DD_HH_MM_SS_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSSSSS";

    public static final String YYYYMMDDHHMMSS_PATTERN = "yyyyMMddHHmmss";

    public static final String YYYYMMDDHHMMSSMS_PATTERN = "yyyyMMddHHmmssSSSSSS";

    public static final String YYYY_MM_DD_PATTERN = "yyyy-MM-dd";

    public static final String YYYYMMDD_PATTERN = "yyyyMMdd";
    public static final String DD_PATTERN = "d";
    public static final String HHMM_PATTERN = "HH:mm";
    public static final String MM_PATTERN = "mm";
    public static final String HH_PATTERN = "HH";
    public static int returnType_YYYYMMDD = 0;

    public static int returnType_YYYYMMDD_hhmmssms = 1;

    public static int returnType_hhmmss = 2;

    public static String DATE_WEEK = "WEEK";

    public static String DATE_TENDAY = "TENDAY";

    public static String DATE_HALF_MONTH = "HALF_MONTH";

    public static String DATE_MONTH = "MONTH";

    public static String DATE_QUARTER = "QUARTER";

    public static int TimeType_Hour = 1;
    public static int TimeType_Minute = 2;
    public static int TimeType_Second = 3;
    public static int TimeType_Millisecond = 4;
    public static int TimeType_Hour_Minute = 5;
    public static int TimeType_Hour_Minute_Second = 6;
    public static int TimeType_Hour_Minute_Second_Millisecond = 7;

    /**
     * 查询当前日期相隔天数的日期
     * 
     * @param days
     * @return String
     */
    @SuppressWarnings("static-access")
    public static String getBeforDay(int days, String pattern)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.DATE, -days);
        return getDateTime(cal.getTime(), pattern);
    }

    /**
     * 查询当前日期相隔指定月的日期
     * 
     * @param days
     * @return String
     */
    @SuppressWarnings("static-access")
    public static String getBeforMonth(int months, String pattern)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, -months);
        return getDateTime(cal.getTime(), pattern);
    }

    /**
     * 查询当前日期相隔指定年的日期
     * 
     * @param days int
     * @return String
     */
    @SuppressWarnings("static-access")
    public static String getBeforYear(int yeas, String pattern)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.YEAR, -yeas);
        return getDateTime(cal.getTime(), pattern);
    }

    /**
     * 返回当前时间的字符串值
     * 
     * @param pattern String 如："yyyy-MM-dd HH:mm:ss"
     * @return String
     */
    public static String getDateTime(String pattern)
    {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dt = sdf.format(new Date());
        return dt;
    }

    /**
     * 返回指定时间的指定格式的字符串值
     * 
     * @param date Date
     * @param pattern String 如："yyyy-MM-dd HH:mm:ss"
     * @return String
     */
    public static String getDateTime(Date date, String pattern)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将指定字符串转换成日期格式
     * 
     * @param String param, 格式: "yyyy-MM-dd HH:mm:ss".
     * @return Date
     */
    public static Date parseDateTime(String param, String pattern)
    {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try
        {
            date = sdf.parse(param);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return date;
    }

    /**
     * 将指定字符串转换成数据库日期格式
     * 
     * @param param
     * @param pattern 日期格式，如：yyyy-MM-dd
     * @return Date
     */
    public static java.sql.Date parseSQLDateTime(String param, String pattern)
    {
        java.sql.Date sdf = null;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try
        {
            if (param != null)
            {
                java.util.Date dd = format.parse(param);
                sdf = new java.sql.Date(dd.getTime());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return sdf;
    }

    /**
     * 将指定字符串转换成日期格式
     * 
     * @param param
     * @param pattern 日期格式
     * @return Date
     */
    public static Date parseDate(String param, String pattern)
    {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try
        {
            date = sdf.parse(param);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return date;
    }

    /**
     * 判断输入的日期是否正确
     * 
     * @param param
     * @param pattern 转换格式
     * @return boolean
     */
    public static boolean isValidDate(String param, String pattern)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.parse(param);
        }
        catch (ParseException ex)
        {
            return false;
        }
        return true;
    }

    /**
     * 判断是星期几
     * 
     * @param date
     * @param pattern String
     * @return int
     */
    public static int isWeekDay(java.sql.Date date, String pattern)
    {
        int result = -1;
        java.util.Date d = parseDate(date.toString(), pattern);
        SimpleDateFormat dd = new SimpleDateFormat("E");
        String str = dd.format(d);
        String tmpstr = str.substring(2, str.length());
        if (tmpstr.equals("一") || str.equalsIgnoreCase("Mon"))
        {
            result = 1;
        }
        else if (tmpstr.equals("二") || str.equalsIgnoreCase("Tue"))
        {
            result = 2;
        }
        else if (tmpstr.equals("三") || str.equalsIgnoreCase("Wed"))
        {
            result = 3;
        }
        else if (tmpstr.equals("四") || str.equalsIgnoreCase("Thu"))
        {
            result = 4;
        }
        else if (tmpstr.equals("五") || str.equalsIgnoreCase("Fri"))
        {
            result = 5;
        }
        else if (tmpstr.equals("六") || str.equalsIgnoreCase("Sat"))
        {
            result = 6;
        }
        else if (tmpstr.equals("日") || str.equalsIgnoreCase("Sun"))
        {
            result = 7;
        }
        return result;
    }

    /**
     * 获得当前时间是星期几
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String getWeekDay(String date, String pattern)
    {
        String result = "";
        java.util.Date d = parseDate(date, pattern);
        SimpleDateFormat dd = new SimpleDateFormat("E");
        result = dd.format(d);
        if (result.equals("Mon"))
        {
            result = "星期一";
        }
        else if (result.equals("Tue"))
        {
            result = "星期二";
        }
        else if (result.equals("Wed"))
        {
            result = "星期三";
        }
        else if (result.equals("Thu"))
        {
            result = "星期四";
        }
        else if (result.equals("Fri"))
        {
            result = "星期五";
        }
        else if (result.equals("Sat"))
        {
            result = "星期六";
        }
        else if (result.equals("Sun"))
        {
            result = "星期日";
        }
        return result;
    }

    /**
     * 获取当前年所有月份的天数
     * 
     * @param date
     * @return
     */
    public static int[] getMothDay(java.util.Date date)
    {
        int[] result = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String str = DateTimeUtil.getDateTime(date, "yyyy");
        int year = Integer.parseInt(str.substring(0, 4));
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
        {
            result[1] = 29;
        }
        return result;

    }

    /**
     * 获取当前周的第一天
     * 
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date firstDayOfThisWeek()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.DAY_OF_WEEK, cal.getMinimum(cal.DAY_OF_WEEK));
        return cal.getTime();
    }

    /**
     * 获取当前周最后一天
     * 
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date endDayOfThisWeek()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.WEEK_OF_MONTH, cal.get(cal.WEEK_OF_MONTH) + 1);
        cal.set(cal.DAY_OF_WEEK, cal.getMinimum(cal.DAY_OF_WEEK));
        cal.add(cal.DAY_OF_WEEK, -1);
        return cal.getTime();
    }

    /**
     * 将日期转化成SQL日期
     * 
     * @param param
     * @return
     */
    public static java.sql.Date getSqlDate(String param)
    {
        return param == null ? null : java.sql.Date.valueOf(param);
    }

    /**
     * 将时间转化为SQL时间
     * 
     * @param param
     * @return
     */
    public static java.sql.Time getSqlTime(String param)
    {
        return param == null ? null : java.sql.Time.valueOf(param);
    }

    /**
     * 将日期时间转化为SQL日期时间
     * 
     * @param param
     * @return
     */
    public static java.sql.Timestamp getSqlTimeStamp(String param)
    {
        return param == null ? null : java.sql.Timestamp.valueOf(param);
    }

    public static java.util.Date getDate(String dateStr, String dateFormat) throws ParseException
    {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        return df.parse(dateStr);
    }

    public static java.util.Date getDate(String dateStr, String dateFormat, Locale locale) throws ParseException
    {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat, locale);
        return df.parse(dateStr);
    }

    public static Calendar getCalendar(String dateStr, String dateFormat) throws ParseException
    {
        Calendar c = null;
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        java.util.Date date = df.parse(dateStr);
        if (date != null)
        {
            c = Calendar.getInstance();
            c.setTime(date);
        }
        return c;
    }

    public static Calendar getCalendar(java.util.Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 取得当前的时间(YYYY-MM-DD hh:mm:ss) 2005-7-29 16:31:48
     * 
     * @return 当前的时间(YYYY-MM-DD hh:mm:ss)
     */
    public static String getCurrentDate()
    {
        // String result = "";

        Calendar calendar = Calendar.getInstance();
        int yea = calendar.get(Calendar.YEAR);
        int mon = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // int wkd = calendar.get(Calendar.DAY_OF_WEEK);
        int hou = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        int msc = calendar.get(Calendar.MILLISECOND);

        String _yea = "";
        String _mon = "";
        String _day = "";
        // String _wkd = "";
        String _hou = "";
        String _min = "";
        String _sec = "";
        String _msc = "";

        _yea = "" + yea;

        if (mon < 10)
            _mon = "0" + mon;
        else
            _mon = String.valueOf(mon);

        if (day < 10)
            _day = "0" + day;
        else
            _day = String.valueOf(day);

        if (hou < 10)
            _hou = "0" + hou;
        else
            _hou = String.valueOf(hou);

        if (min < 10)
            _min = "0" + min;
        else
            _min = String.valueOf(min);

        if (sec < 10)
            _sec = "0" + sec;
        else
            _sec = String.valueOf(sec);

        _msc = String.valueOf(msc);

        return _yea + "-" + _mon + "-" + _day + " " + _hou + ":" + _min + ":" + _sec;
    }

    public static String getCurrentTime(int type, String separator)
    {
        String result = "";

        Calendar calendar = Calendar.getInstance();

        int hou = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        int msc = calendar.get(Calendar.MILLISECOND);

        String _hou = "";
        String _min = "";
        String _sec = "";
        String _msc = "";

        if (hou < 10)
            _hou = "0" + hou;
        else
            _hou = String.valueOf(hou);

        if (min < 10)
            _min = "0" + min;
        else
            _min = String.valueOf(min);

        if (sec < 10)
            _sec = "0" + sec;
        else
            _sec = String.valueOf(sec);

        _msc = String.valueOf(msc);

        switch (type)
        {
            case 1:
                result = _hou;
                break;
            case 2:
                result = _min;
                break;
            case 3:
                result = _sec;
                break;
            case 4:
                result = _msc;
                break;
            case 5:
                result = _hou + separator + _min;
                break;
            case 6:
                result = _hou + separator + _min + separator + _sec;
                break;
            case 7:
                result = _hou + separator + _min + separator + _sec + separator + _msc;
                break;
            default:
                result = _hou + separator + _min + separator + _sec;
                break;
        }
        return result;
    }

    /**
     * 得到一个年月的第一天(YYYYMMDD)
     * 
     * @param YearMonth
     *            年月(YYYYMM)
     * @return 月的第一天(YYYYMMDD)
     */
    public static String getMonthFirstDay(String YearMonth)
    {
        return YearMonth + "01";
    }

    /**
     * 月份加减
     * 
     * @param YearMonth 年月(YYYYMM)
     * @param AddNum 加减数量
     * @return ...
     */
    public static String MonthAdd(String YearMonth, int AddNum)
    {
        // String result = "";

        int y = Integer.parseInt(YearMonth.substring(0, 4));
        int m = Integer.parseInt(YearMonth.substring(4, 6));
        AddNum = AddNum - 1;

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH, m);
        c.add(Calendar.MONTH, AddNum);

        int _y = c.get(Calendar.YEAR);
        int _m = c.get(Calendar.MONTH) + 1;

        String month = "";
        if (_m < 10)
        {
            month = "0" + _m;
        }
        else
        {
            month = String.valueOf(_m);
        }

        return _y + month;
    }
    
    /**
     * 得到一个年月的最后一天(YYYYMMDD)
     * 
     * @param YearMonth
     *            年月(YYYYMM)
     * @return 月的最大天数(YYYYMMDD)
     */
    public static String getMonthEndDay(String YearMonth)
    {
        String maxDays = "31";
        String result = null;
        int y = Integer.parseInt(YearMonth.substring(0, 4));
        int m = Integer.parseInt(YearMonth.substring(4, 6));

        if (m == 4 | m == 6 | m == 9 | m == 11)
            maxDays = "30";
        if (m == 1 | m == 3 | m == 5 | m == 7 | m == 8 | m == 10 | m == 12)
            maxDays = "31";
        // if(m==2) maxDays = "28";
        if (m == 2)
            if ((y % 4 == 0 & y % 100 != 0 | y % 400 == 0))
                maxDays = "29";
            else
                maxDays = "28";
        // //System.out.println("year="+y+" month="+m+" day="+maxDays);
        if (m < 10)
        {
            result = y + "0" + m + maxDays;
        }
        else
        {
            result = String.valueOf(y) + String.valueOf(m) + String.valueOf(maxDays);
        }
        return result;
    }

    /**
     * 获得昨天的日期，数字型字符串
     * 
     * @return 昨天的日期yyyymmdd
     */
    public static String getYestodayNo()
    {
        String result = "";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        result = "" + cal.get(Calendar.YEAR);
        if ((cal.get(Calendar.MONTH) + 1) < 10)
        {
            result += "0" + (cal.get(Calendar.MONTH) + 1);
        }
        else
        {
            result += "" + (cal.get(Calendar.MONTH) + 1);
        }
        if (cal.get(Calendar.DAY_OF_MONTH) < 10)
        {
            result += "0" + cal.get(Calendar.DAY_OF_MONTH);
        }
        else
        {
            result += "" + cal.get(Calendar.DAY_OF_MONTH);
        }
        return result;
    }

    /**
     * 获得昨天的日期，中文字符串
     * 
     * @return 昨天的日期:yyyy年mm月dd日
     */
    public static String getYestodayCn(String sj)
    {
        String result = "";
        if (sj.length() >= 7)
            result = sj.substring(0, 4) + "年" + sj.substring(4, 6) + "月" + sj.substring(6) + "日";
        else if (sj.length() == 6)
            result = sj.substring(0, 4) + "年" + sj.substring(4, 6) + "月";
        else
            result = sj.substring(0, 4) + "年";
        return result;
    }

    /**
     * 获得给定分隔符的日期串.
     * 
     * @param yyyymmdd
     *            日期,格式:YYYYMMDD
     * @param separator
     *            分隔符.
     * @return 给定分隔符的日期串,如:YYYY-MM-DD
     */
    public static String getDateWithSeparator(String yyyymmdd, String separator)
    {
        String result = "";
        result = yyyymmdd.substring(0, 4) + separator + yyyymmdd.substring(4, 6) + separator + yyyymmdd.substring(6);
        return result;
    }

    /**
     * 取得明天的日期
     * 
     * @param rq String 8位数字符行日期YYYYMMDD
     * @return 明天的日期YYYYMMDD
     */
    public static String getDayAdd(String rq)
    {
        String result = "";
        int y = Integer.parseInt(rq.substring(0, 4));
        int m = Integer.parseInt(rq.substring(4, 6));
        int d = Integer.parseInt(rq.substring(6));

        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, y);
        // //System.out.println("YEAR = "+c.get(Calendar.YEAR));
        c.set(Calendar.MONTH, m - 1);
        // //System.out.println("MONTH = "+c.get(Calendar.MONTH));
        c.set(Calendar.DATE, d);
        // //System.out.println("DATE = "+c.get(Calendar.DATE));

        // //System.out.println("DAY_OF_YEAR = "+c.get(Calendar.DAY_OF_YEAR));
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
        // //System.out.println("DAY_OF_YEAR = "+c.get(Calendar.DAY_OF_YEAR));

        int _y = c.get(Calendar.YEAR);
        // //System.out.println("YEAR = "+_y);
        int _m = c.get(Calendar.MONTH) + 1;
        // //System.out.println("MONTH = "+_m);
        int _d = c.get(Calendar.DAY_OF_MONTH);
        // //System.out.println("DAY_OF_MONTH = "+_d);

        result = "" + _y;
        if (_m < 10)
        {
            result += "0" + _m;
        }
        else
        {
            result += "" + _m;
        }
        if (_d < 10)
        {
            result += "0" + _d;
        }
        else
        {
            result += "" + _d;
        }
        // //System.out.println("getDayAdd = "+result);
        return result;
    }

    /**
     * 取得Calendar日历对象. 2005-3-25 14:38:18
     * 
     * @param yyyymmdd 日期格式:YYYYMMDD;
     * @return ...
     */
    public static Calendar getCalendar(String yyyymmdd)
    {
        int y = Integer.parseInt(yyyymmdd.substring(0, 4));
        int m = Integer.parseInt(yyyymmdd.substring(4, 6));
        int d = Integer.parseInt(yyyymmdd.substring(6));

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH, m - 1);
        c.set(Calendar.DAY_OF_MONTH, d);
        // c.add(Calendar.MONTH, -1);
        return c;
    }

    /**
     * 取得Calendar日历对象
     * 
     * @param yyyymmddhhmissms
     * @param separator 日期时间分割符
     * @param separator1 日期分割符
     * @param separator2 时间分割符
     * @param separator3 毫秒分割符
     * @return ...
     */
    public static Calendar getCalendar(String yyyymmddhhmissms, String separator, String separator1, String separator2,
            String separator3)
    {
        int y = Integer.parseInt(yyyymmddhhmissms.substring(0, yyyymmddhhmissms.indexOf(separator1)));
        // System.out.println("y:"+y);
        int m = Integer.parseInt(yyyymmddhhmissms.substring(yyyymmddhhmissms.indexOf(separator1) + 1,
                yyyymmddhhmissms.lastIndexOf(separator1)));
        // System.out.println("m:"+m);
        int d = Integer.parseInt(yyyymmddhhmissms.substring(yyyymmddhhmissms.lastIndexOf(separator1) + 1,
                yyyymmddhhmissms.indexOf(separator)));
        // System.out.println("d:"+d);
        int hh = Integer.parseInt(yyyymmddhhmissms.substring(yyyymmddhhmissms.indexOf(separator) + 1,
                yyyymmddhhmissms.indexOf(separator2)));
        // System.out.println("hh:"+hh);
        int mi = Integer.parseInt(yyyymmddhhmissms.substring(yyyymmddhhmissms.indexOf(separator2) + 1,
                yyyymmddhhmissms.lastIndexOf(separator2)));
        // System.out.println("mi:"+mi);
        int ss = Integer.parseInt(yyyymmddhhmissms.substring(yyyymmddhhmissms.lastIndexOf(separator2) + 1,
                yyyymmddhhmissms.indexOf(separator3)));
        // System.out.println("ss:"+ss);
        int ms = Integer.parseInt(yyyymmddhhmissms.substring(yyyymmddhhmissms.indexOf(separator3) + 1));
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH, m - 1);
        c.set(Calendar.DAY_OF_MONTH, d);
        c.set(Calendar.HOUR_OF_DAY, hh);
        c.set(Calendar.MINUTE, mi);
        c.set(Calendar.SECOND, ss);
        c.set(Calendar.MILLISECOND, ms);
        // c.add(Calendar.MONTH, -1);
        return c;
    }

    /**
     * 清除间隔符,返回日期格式如:YYYYMMDD 2005-3-25 14:53:12
     * 
     * @param dateStr 日期,格式如:YYYY-MM-DD,YYYY年MM月DD日
     * @param separator 间隔符字串.如:"-","年月日".
     * @return YYYYMMDD
     */
    public static String CleanSeparator(String dateStr, String separator)
    {
        StringBuffer result = new StringBuffer(512);
        int idx = 0;

        while (dateStr.length() > 0)
        {
            if (separator.indexOf(dateStr.charAt(idx)) >= 0)
            {
                if (idx == 0)
                    if (dateStr.length() != 1)
                        dateStr = dateStr.substring(idx + 1);
                    else
                        return result.toString();
                else
                    result.append(dateStr.substring(0, idx));
                idx = -1;
            }
            idx++;
        }

        return result.toString();
    }

    /**
     * 取得日期字符串.格式如:YYYYMMDD 2005-3-25 15:18:39
     * 
     * @param calendar 日期
     * @param returnType 返回字串的格式类型,可通过本类的常量来区分
     * @param separator1 年月的分隔符
     * @param separator2 时分秒的分隔符
     * @param separator 年月和时分的分隔符
     * @return 日期字符串.格式:YYYYMMDD
     */
    public static String getDateString(Calendar calendar, int returnType, String separator1, String separator2)
    {
        String result = "";

        int yea = calendar.get(Calendar.YEAR);
        int mon = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hou = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        int msc = calendar.get(Calendar.MILLISECOND);

        String _yea = "";
        String _mon = "";
        String _day = "";
        String _hou = "";
        String _min = "";
        String _sec = "";
        String _msc = "";

        _yea = "" + yea;

        if (mon < 10)
            _mon = "0" + mon;
        else
            _mon = String.valueOf(mon);

        if (day < 10)
            _day = "0" + day;
        else
            _day = String.valueOf(day);

        if (hou < 10)
            _hou = "0" + hou;
        else
            _hou = String.valueOf(hou);

        if (min < 10)
            _min = "0" + min;
        else
            _min = String.valueOf(min);

        if (sec < 10)
            _sec = "0" + sec;
        else
            _sec = String.valueOf(sec);

        _msc = String.valueOf(msc);

        /**
         * public static int returnType_YYYYMMDD = 0; public static int
         * returnType_YYYYMMDD_hhmmssms = 1; public static int returnType_hhmmss
         * =
         * 2;
         */

        if (returnType == returnType_YYYYMMDD)
            result = _yea + separator1 + _mon + separator1 + _day;
        if (returnType == returnType_YYYYMMDD_hhmmssms)
            result = _yea + separator1 + _mon + separator1 + _day + separator1 + _hou + separator2 + _min + separator2
                    + _sec + separator2 + _msc;
        if (returnType == returnType_hhmmss)
            result = _hou + separator2 + _min + separator2 + _sec + separator2;

        return result;
    }

    /**
     * 取得日期字符串.格式如:YYYYMMDD 2005-3-25 15:18:39
     * 
     * @param calendar 日期
     * @param returnType 返回字串的格式类型,可通过本类的常量来区分
     * @param separator1 年月的分隔符
     * @param separator2 时分秒的分隔符
     * @param separator 年月和时分的分隔符
     * @return 日期字符串.格式:YYYYMMDD
     */
    public static String getDateString(java.util.Date date, int returnType, String separator1, String separator2)
    {
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int yea = calendar.get(Calendar.YEAR);
        int mon = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hou = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        int msc = calendar.get(Calendar.MILLISECOND);

        String _yea = "";
        String _mon = "";
        String _day = "";
        String _hou = "";
        String _min = "";
        String _sec = "";
        String _msc = "";

        _yea = "" + yea;

        if (mon < 10)
            _mon = "0" + mon;
        else
            _mon = String.valueOf(mon);

        if (day < 10)
            _day = "0" + day;
        else
            _day = String.valueOf(day);

        if (hou < 10)
            _hou = "0" + hou;
        else
            _hou = String.valueOf(hou);

        if (min < 10)
            _min = "0" + min;
        else
            _min = String.valueOf(min);

        if (sec < 10)
            _sec = "0" + sec;
        else
            _sec = String.valueOf(sec);

        _msc = String.valueOf(msc);

        /**
         * public static int returnType_YYYYMMDD = 0; public static int
         * returnType_YYYYMMDD_hhmmssms = 1; public static int returnType_hhmmss
         * =
         * 2;
         */

        if (returnType == returnType_YYYYMMDD)
            result = _yea + separator1 + _mon + separator1 + _day;
        if (returnType == returnType_YYYYMMDD_hhmmssms)
            result = _yea + separator1 + _mon + separator1 + _day + separator1 + _hou + separator2 + _min + separator2
                    + _sec + separator2 + _msc;
        if (returnType == returnType_hhmmss)
            result = _hou + separator2 + _min + separator2 + _sec + separator2;

        return result;
    }

    /**
     * 取得当前时间,按不同的格式. 2005-7-29 16:37:07
     * 
     * @param returnType 返回字串的格式类型,可通过本类的常量来区分
     * @param separator1 年月的分隔符
     * @param separator2 时分秒的分隔符
     * @param separator 年月和时分的分隔符
     * @return 时间字符串
     */
    public static String getCurrentDateString(int returnType, String separator1, String separator2)
    {
        String result = "";

        Calendar calendar = Calendar.getInstance();
        int yea = calendar.get(Calendar.YEAR);
        int mon = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // int wkd = calendar.get(Calendar.DAY_OF_WEEK);
        int hou = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        int msc = calendar.get(Calendar.MILLISECOND);

        String _yea = "";
        String _mon = "";
        String _day = "";
        // String _wkd = "";
        String _hou = "";
        String _min = "";
        String _sec = "";
        String _msc = "";

        _yea = "" + yea;

        if (mon < 10)
            _mon = "0" + mon;
        else
            _mon = String.valueOf(mon);

        if (day < 10)
            _day = "0" + day;
        else
            _day = String.valueOf(day);

        if (hou < 10)
            _hou = "0" + hou;
        else
            _hou = String.valueOf(hou);

        if (min < 10)
            _min = "0" + min;
        else
            _min = String.valueOf(min);

        if (sec < 10)
            _sec = "0" + sec;
        else
            _sec = String.valueOf(sec);

        _msc = String.valueOf(msc);

        /**
         * public static int returnType_YYYYMMDD = 0; public static int
         * returnType_YYYYMMDD_hhmmssms = 1; public static int returnType_hhmmss
         * =
         * 2;
         */

        if (returnType == returnType_YYYYMMDD)
            result = _yea + separator1 + _mon + separator1 + _day;
        if (returnType == returnType_YYYYMMDD_hhmmssms)
            result = _yea + separator1 + _mon + separator1 + _day + separator1 + _hou + separator2 + _min + separator2
                    + _sec + separator2 + _msc;
        if (returnType == returnType_hhmmss)
            result = _hou + separator2 + _min + separator2 + _sec + separator2;

        return result;
    }

    /**
     * 取得当前时间,按不同的格式. 2005-7-29 16:37:07
     * 
     * @param returnType
     *            返回字串的格式类型,可通过本类的常量来区分
     * @param separator 年月和时分的分隔符
     * @param separator1 年月的分隔符
     * @param separator2 时分秒的分隔符
     * @return 时间字符串
     */
    public static String getCurrentDateString(int returnType, String separator, String separator1, String separator2)
    {
        String result = "";

        Calendar calendar = Calendar.getInstance();
        int yea = calendar.get(Calendar.YEAR);
        int mon = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // int wkd = calendar.get(Calendar.DAY_OF_WEEK);
        int hou = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        int msc = calendar.get(Calendar.MILLISECOND);

        String _yea = "";
        String _mon = "";
        String _day = "";
        // String _wkd = "";
        String _hou = "";
        String _min = "";
        String _sec = "";
        String _msc = "";

        _yea = "" + yea;

        if (mon < 10)
            _mon = "0" + mon;
        else
            _mon = String.valueOf(mon);

        if (day < 10)
            _day = "0" + day;
        else
            _day = String.valueOf(day);

        if (hou < 10)
            _hou = "0" + hou;
        else
            _hou = String.valueOf(hou);

        if (min < 10)
            _min = "0" + min;
        else
            _min = String.valueOf(min);

        if (sec < 10)
            _sec = "0" + sec;
        else
            _sec = String.valueOf(sec);

        _msc = String.valueOf(msc);

        /**
         * public static int returnType_YYYYMMDD = 0; public static int
         * returnType_YYYYMMDD_hhmmssms = 1; public static int returnType_hhmmss
         * =
         * 2;
         */

        if (returnType == returnType_YYYYMMDD)
            result = _yea + separator1 + _mon + separator1 + _day;
        if (returnType == returnType_YYYYMMDD_hhmmssms)
            result = _yea + separator1 + _mon + separator1 + _day + separator + _hou + separator2 + _min + separator2
                    + _sec + separator2 + _msc;
        if (returnType == returnType_hhmmss)
            result = _hou + separator2 + _min + separator2 + _sec + separator2;

        return result;
    }

    /**
     * 日期加减方法 2005-3-25 13:03:41
     * 
     * @param yyyymmdd
     *            年月日时间.格式:YYYYMMDD
     * @param offset
     *            日期迁移量.正:加,负:减
     * @return YYYYMMDD
     */
    public static String getDayAdd(String yyyymmdd, int offset)
    {
        String result = "";
        int y = Integer.parseInt(yyyymmdd.substring(0, 4));
        int m = Integer.parseInt(yyyymmdd.substring(4, 6));
        int d = Integer.parseInt(yyyymmdd.substring(6));

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH + 1, m);
        c.set(Calendar.DAY_OF_MONTH, d);
        c.add(Calendar.DATE, offset);

        int _y = c.get(Calendar.YEAR);
        int _m = c.get(Calendar.MONTH) + 1;
        int _d = c.get(Calendar.DAY_OF_MONTH);

        result = "" + _y;
        if (_m < 10)
        {
            result += "0" + _m;
        }
        else
        {
            result += "" + _m;
        }
        if (_d < 10)
        {
            result += "0" + _d;
        }
        else
        {
            result += "" + _d;
        }
        // System.out.println("getDayAdd = " + result);
        return result;
    }

    /**
     * 将日期字符串格式化为特定类型的字符串. 2005-5-8 11:51:18
     * 
     * @param type 0: YYYY-MM-DD to YYYYMMDD<br>
     * @param dateStr
     * @return ...
     */
    public static String getFormatDateStr(int type, String dateStr)
    {
        String result = "";

        switch (type)
        {
            case 0:
                result = dateStr.replaceAll("-", "");
                break;
            default:
                result = dateStr;
                break;
        }

        return result;
    }

    /**
     * 比较日期dateStr是否在dateStr2的前beforeDate，后afterDate的天
     * 
     * @param beforeDate
     * @param afterDate
     * @param dateStr
     * @param dateStr2
     * @return ...
     */
    public static boolean getDateStatus(int beforeDate, int afterDate, String dateStr, String dateStr2)
    {

        if (dateStr == null || dateStr.length() < 8)
            dateStr = DateTimeUtil.getCurrentDateString(returnType_YYYYMMDD, "", "");
        Calendar c = DateTimeUtil.getCalendar(dateStr);
        // //System.out.println("====" + SysDate.getDateString(c));
        Calendar c2 = DateTimeUtil.getCalendar(dateStr2);
        // //System.out.println("----" + SysDate.getDateString(c2));
        Calendar tmp = DateTimeUtil.getCalendar(dateStr2);

        c2.add(Calendar.DATE, -beforeDate);
        // //System.out.println("++++" + SysDate.getDateString(c2));
        tmp.add(Calendar.DATE, afterDate);
        // //System.out.println("****" + SysDate.getDateString(tmp));
        if (c2.before(c) && tmp.after(c))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * 判断日期d1是否在日期d2之前
     * 方法创建时间: 2008-2-25 下午08:49:47<br>
     * 
     * @param d1 日期d1
     * @param d2 日期d2
     * @return true:d1<d2 否则 false: d1>d2 <br>
     */
    public static boolean isBeforeDate(java.sql.Date d1, java.sql.Date d2)
    {

        if (d1 == null)
            return true;
        if (d2 == null)
            return false;
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        return c1.before(c2);
    }

    public static boolean isAfterDate(java.sql.Date d1, java.sql.Date d2)
    {
        if (d2 == null)
            return true;
        return d1.after(d2);
    }

    /**
     * 获得指定日期，日期格式，日期类型的第一天（中式）
     * 
     * @param dateStr
     * @param formateDate
     * @param type
     * @return ...
     */
    public static String getFirstDate(String dateStr, String formateDate, String type)
    {
        String result = "";
        int year = 0;
        int month = 0;
        int day = 0;

        Calendar tmp = Calendar.getInstance();
        Calendar c = DateTimeUtil.getCalendar(dateStr);

        // 周
        if (type.equals(DateTimeUtil.DATE_WEEK))
        {
            if (c.get(Calendar.DAY_OF_WEEK) == 1)
                c.add(Calendar.DATE, -7);
            // //System.out.println("++++" + SysDate.getDateString(c));
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.WEEK_OF_YEAR, c.get(Calendar.WEEK_OF_YEAR));
            tmp.set(Calendar.DAY_OF_WEEK, 2);
            // //System.out.println("----" + SysDate.getDateString(tmp));
        }
        // 旬
        if (type.equals(DateTimeUtil.DATE_TENDAY))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.MONTH, c.get(Calendar.MONTH));
            if (c.get(Calendar.DAY_OF_MONTH) <= 10)
                tmp.set(Calendar.DAY_OF_MONTH, 1);
            else if (c.get(Calendar.DAY_OF_MONTH) > 10 && c.get(Calendar.DAY_OF_MONTH) <= 20)
                tmp.set(Calendar.DAY_OF_MONTH, 11);
            else
                tmp.set(Calendar.DAY_OF_MONTH, 21);

        }
        // 半月
        if (type.equals(DateTimeUtil.DATE_HALF_MONTH))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.MONTH, c.get(Calendar.MONTH));
            if (c.get(Calendar.DAY_OF_MONTH) <= 15)
                tmp.set(Calendar.DAY_OF_MONTH, 1);
            else
                tmp.set(Calendar.DAY_OF_MONTH, 16);

        }
        // 月
        if (type.equals(DateTimeUtil.DATE_MONTH))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.MONTH, c.get(Calendar.MONTH));
            tmp.set(Calendar.DAY_OF_MONTH, 1);
        }
        // 季度
        if (type.equals(DateTimeUtil.DATE_QUARTER))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            if (c.get(Calendar.MONTH) <= 2)
            {
                tmp.set(Calendar.MONTH, 0);
            }
            else if (c.get(Calendar.MONTH) > 2 && c.get(Calendar.MONTH) <= 5)
            {
                tmp.set(Calendar.MONTH, 3);

            }
            else if (c.get(Calendar.MONTH) > 5 && c.get(Calendar.MONTH) <= 8)
            {
                tmp.set(Calendar.MONTH, 6);

            }
            else
            {
                tmp.set(Calendar.MONTH, 9);

            }

            tmp.set(Calendar.DAY_OF_MONTH, 1);

        }

        year = tmp.get(Calendar.YEAR);
        month = tmp.get(Calendar.MONTH) + 1;
        day = tmp.get(Calendar.DAY_OF_MONTH);
        // 格式化日期
        if (formateDate.toUpperCase().equals("YYYYMMDD"))
        {
            result = "" + year;
            if (month < 10)
            {
                result += "0" + month;
            }
            else
            {
                result += month;
            }
        }
        if (formateDate.toUpperCase().equals("MMDD"))
        {
            if (month < 10)
            {
                result += "0" + month;
            }
            else
            {
                result += month;
            }
        }

        if (day < 10)
        {
            result += "0" + day;
        }
        else
        {
            result += day;
        }
        return result;
    }

    /**
     * 获得指定日期，日期格式，日期类型的最后一天（中式）
     * 
     * @param dateStr
     * @param formateDate
     * @param type
     * @return ...
     */
    public static String getLastDate(String dateStr, String formateDate, String type)
    {
        String result = "";
        int year = 0;
        int month = 0;
        int day = 0;

        Calendar tmp = Calendar.getInstance();
        Calendar c = DateTimeUtil.getCalendar(dateStr);

        // 周
        if (type.equals(DateTimeUtil.DATE_WEEK))
        {
            if (c.get(Calendar.DAY_OF_WEEK) != 1)
                c.add(Calendar.DATE, 7);
            // //System.out.println("++++" + SysDate.getDateString(c));
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.WEEK_OF_YEAR, c.get(Calendar.WEEK_OF_YEAR));
            tmp.set(Calendar.DAY_OF_WEEK, 1);
            // //System.out.println("----" + SysDate.getDateString(tmp));
        }
        // 旬
        if (type.equals(DateTimeUtil.DATE_TENDAY))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.MONTH, c.get(Calendar.MONTH));
            if (c.get(Calendar.DAY_OF_MONTH) <= 10)
                tmp.set(Calendar.DAY_OF_MONTH, 10);
            else if (c.get(Calendar.DAY_OF_MONTH) > 10 && c.get(Calendar.DAY_OF_MONTH) <= 20)
                tmp.set(Calendar.DAY_OF_MONTH, 20);
            else
            {
                c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.DATE, -1);
                tmp.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
            }

        }
        // 半月
        if (type.equals(DateTimeUtil.DATE_HALF_MONTH))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.MONTH, c.get(Calendar.MONTH));
            if (c.get(Calendar.DAY_OF_MONTH) <= 15)
                tmp.set(Calendar.DAY_OF_MONTH, 15);
            else
            {
                c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.DATE, -1);
                tmp.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
            }

        }
        // 月
        if (type.equals(DateTimeUtil.DATE_MONTH))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            tmp.set(Calendar.MONTH, c.get(Calendar.MONTH));
            c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.add(Calendar.DATE, -1);
            tmp.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
        }

        // 季度
        if (type.equals(DateTimeUtil.DATE_QUARTER))
        {
            tmp.set(Calendar.YEAR, c.get(Calendar.YEAR));
            if (c.get(Calendar.MONTH) <= 2)
            {
                tmp.set(Calendar.MONTH, 2);
                c.set(Calendar.MONTH, 3);
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.DATE, -1);
                tmp.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
            }
            else if (c.get(Calendar.MONTH) > 2 && c.get(Calendar.MONTH) <= 5)
            {
                tmp.set(Calendar.MONTH, 5);
                c.set(Calendar.MONTH, 6);
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.DATE, -1);
                tmp.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));

            }
            else if (c.get(Calendar.MONTH) > 5 && c.get(Calendar.MONTH) <= 8)
            {
                tmp.set(Calendar.MONTH, 8);
                c.set(Calendar.MONTH, 9);
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.DATE, -1);
                tmp.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));

            }
            else
            {
                tmp.set(Calendar.MONTH, 11);
                c.set(Calendar.MONTH, 12);
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.DATE, -1);
                tmp.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));

            }

        }

        year = tmp.get(Calendar.YEAR);
        month = tmp.get(Calendar.MONTH) + 1;
        day = tmp.get(Calendar.DAY_OF_MONTH);
        // 格式化日期
        if (formateDate.toUpperCase().equals("YYYYMMDD"))
        {
            result = "" + year;
            if (month < 10)
            {
                result += "0" + month;
            }
            else
            {
                result += month;
            }
        }
        if (formateDate.toUpperCase().equals("MMDD"))
        {
            if (month < 10)
            {
                result += "0" + month;
            }
            else
            {
                result += month;
            }
        }

        if (day < 10)
        {
            result += "0" + day;
        }
        else
        {
            result += day;
        }
        return result;

    }

    /**
     * 获得指定日期，日期格式，日期类型的第一天（中式）
     * 
     * @param dateStr
     * @param formateDate
     * @param type
     * @return ...
     */
    public static String getFirstDate(String dateStr, String formateDate, String type, String languange)
    {
        String result = "";
        String tmp = DateTimeUtil.getFirstDate(dateStr, "YYYYMMDD", type);
        String year = tmp.substring(0, 4);
        String month = tmp.substring(4, 6);
        String day = tmp.substring(6);
        if (languange != null && languange.equals("CN"))
        {
            // 格式化日期
            if (formateDate.toUpperCase().equals("YYYYMMDD"))
            {
                result = "" + year + "年" + month + "月";

            }
            if (formateDate.toUpperCase().equals("MMDD"))
            {

                result = "" + month + "月";

            }
            result += result = day + "日";
        }
        else
        {
            result = tmp;
        }

        return result;
    }

    /**
     * 获得指定日期，日期格式，日期类型的最后一天（中式）
     * 
     * @param dateStr
     * @param formateDate
     * @param type
     * @return ...
     */
    public static String getLastDate(String dateStr, String formateDate, String type, String languange)
    {
        String result = "";
        String tmp = DateTimeUtil.getLastDate(dateStr, "YYYYMMDD", type);
        String year = tmp.substring(0, 4);
        String month = tmp.substring(4, 6);
        String day = tmp.substring(6);
        if (languange != null && languange.equals("CN"))
        {
            // 格式化日期
            if (formateDate.toUpperCase().equals("YYYYMMDD"))
            {
                result = "" + year + "年" + month + "月";

            }
            if (formateDate.toUpperCase().equals("MMDD"))
            {

                result = "" + month + "月";

            }
            result += result = day + "日";
        }
        else
        {
            result = tmp;
        }

        return result;
    }

    /**
     * 获得两个时间的间隔 cal2 - cal1
     * 
     * @param cal1 Calendar类型
     * @param cal2 Calendar类型
     * @return ...
     */
    public static long getSpaceDate(Calendar cal1, Calendar cal2)
    {
        long result = 0;

        result = cal2.getTime().getTime() - cal1.getTime().getTime();
        result = result / 1000 / 60 / 60 / 24;
        return result;

    }
    public static Date getNextYear(){
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        date = calendar.getTime();
        return date;
    }
    
    public static Date longToDate(Long timestamp) {
    	Date date = null;
    	if(timestamp != null) {
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTimeInMillis(timestamp);
    		date = calendar.getTime();
    	}
    	return date;
    }

    /**
     * 查询某年某月有多少天
     *
     * @param
     * @param
     * @return
     */
    public static int days(String queryDate)
    {

        int year = Integer.valueOf(queryDate.split("-")[0]);
        int month = Integer.valueOf(queryDate.split("-")[1]);
        int days = 0;
        if (month != 2)
        {
            switch (month)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;

            }
        }
        else
        {
            // 闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                days = 29;
            else
                days = 28;
        }
        return days;
    }
    /**
     * 获取前一个月
     * @param yearMonth yyyy-MM
     * @return remark
     */
    public static String getLastMonth(String yearMonth) {
        int year = Integer.valueOf(yearMonth.split("-")[0]);
        int month = Integer.valueOf(yearMonth.split("-")[1]);
        
        String lastMonth = year + "-" + (month - 1);
        if(month == 1) {
            lastMonth = (year - 1) + "-12";
        }
        return lastMonth;
    }
    /**
     * 获取后一个月
     * @param yearMonth yyyy-MM
     * @return remark
     */
    public static String getNextMonth(String yearMonth) {
        int year = Integer.valueOf(yearMonth.split("-")[0]);
        int month = Integer.valueOf(yearMonth.split("-")[1]);
        
        String nextMonth = year + "-" + (month + 1);
        if(month == 12) {
            nextMonth = (year + 1) + "-01";
        }
        return nextMonth;
    }
}