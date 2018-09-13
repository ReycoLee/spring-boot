package com.tabao.core.utils;

import com.alibaba.fastjson.JSON;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hejie on 2017/7/17.
 */
public class DateUtils
{

    /**
     *
     * 通过某一天计算某月有多少周,每周具体哪几号
     * 
     * @param date
     * @return
     */
    public static Map getDateMap(String date)
    {
        Map<String, Object> dataListMap = new HashMap<String, Object>();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        Map map3 = new HashMap();
        Map map4 = new HashMap();
        Map map5 = new HashMap();
        Map map6 = new HashMap();

        Calendar c_now = new GregorianCalendar();
        Calendar c_begin = new GregorianCalendar();
        Calendar c_end = new GregorianCalendar();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weeks = dfs.getWeekdays();

        // 设置参数，年，月
        // String date = "2017-7-1";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        Date cDate = null;
        try
        {
            cDate = df.parse(date);
            c_now.setTime(cDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        int year = c_now.get(Calendar.YEAR);
        int month = c_now.get(Calendar.MONTH) + 1;
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0)
            days[2] = 29;// 大年
        c_begin.set(Integer.parseInt(date.substring(0, 4)), month - 1, 1); // 月
                                                                           // 0-11
                                                                           // 天
                                                                           // 0-
        c_end.set(Integer.parseInt(date.substring(0, 4)), month - 1, days[month]);

        int count = 1;
        int ds = 0;
        c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
        while (c_begin.before(c_end))
        {
            ds = ds + 1;
            String key = "";
            if ("星期一".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)])
                    || "Monday".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]))
                key = "1";
            if ("星期二".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)])
                    || "Tuesday".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]))
                key = "2";
            if ("星期三".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)])
                    || "Wednesday".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]))
                key = "3";
            if ("星期四".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)])
                    || "Thursday".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]))
                key = "4";
            if ("星期五".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)])
                    || "Friday".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]))
                key = "5";
            if ("星期六".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)])
                    || "Saturday".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]))
                key = "6";
            if ("星期日".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)])
                    || "Sunday".equals(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]))
                key = "7";

            String value = new java.sql.Date(c_begin.getTime().getTime()).toString();
            // System.out.println("第" + count + "周  日期：" + value + ", " + key);

            if (count == 1)
            {
                map1.put(key, value);
                dataListMap.put("first", JSON.toJSONString(map1));
            }
            if (count == 2)
            {
                map2.put(key, value);
                dataListMap.put("second", JSON.toJSONString(map2));
            }
            if (count == 3)
            {
                map3.put(key, value);
                dataListMap.put("three", JSON.toJSONString(map3));
            }
            if (count == 4)
            {
                map4.put(key, value);
                dataListMap.put("fourth", JSON.toJSONString(map4));
            }
            if (count == 5)
            {
                map5.put(key, value);
                dataListMap.put("five", JSON.toJSONString(map5));
            }
            if (count == 6)
            {
                map6.put(key, value);
                dataListMap.put("six", JSON.toJSONString(map6));
            }

            if (c_begin.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && !getLastDayOfMonth(year, month).equals(value))
            {
                count++;
            }
            c_begin.add(Calendar.DAY_OF_YEAR, 1);
        }
        // System.out.println("共计（跨越）："+(count-1) +"周");
        dataListMap.put("weekCount", count);
        dataListMap.put("days", ds);
        return dataListMap;
    }

    /**
     * 获取某年某月最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }

    /**
     * 就算周和天数
     * 
     * @param date
     * @return
     */
    public static Map getDaysForMonth(String date)
    {
        Map<String, Object> dataListMap = new HashMap<String, Object>();
        Calendar c_now = new GregorianCalendar();
        Calendar c_begin = new GregorianCalendar();
        Calendar c_end = new GregorianCalendar();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weeks = dfs.getWeekdays();

        // 设置参数，年，月
        // String date = "2017-7-1";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        Date cDate = null;
        try
        {
            cDate = df.parse(date);
            c_now.setTime(cDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        int year = c_now.get(Calendar.YEAR);
        int month = c_now.get(Calendar.MONTH) + 1;
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0)
            days[2] = 29;// 大年
        c_begin.set(Integer.parseInt(date.substring(0, 4)), month - 1, 1); // 月
                                                                           // 0-11
                                                                           // 天
                                                                           // 0-
        c_end.set(Integer.parseInt(date.substring(0, 4)), month - 1, days[month]);

        int count = 1;
        int ds = 0;
        c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
        while (c_begin.before(c_end))
        {
            ds = ds + 1;
            String value = new java.sql.Date(c_begin.getTime().getTime()).toString();
            if (c_begin.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && !getLastDayOfMonth(year, month).equals(value))
            {
                count++;
            }
            c_begin.add(Calendar.DAY_OF_YEAR, 1);
        }
        // System.out.println("共计（跨越）："+(count-1) +"周");
        dataListMap.put("weekCount", count);
        dataListMap.put("days", ds);
        return dataListMap;
    }

    /**
     * 日期是否合法
     * 
     * @param s
     * @return
     */
    public static boolean isValidDate(String s)
    {
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            dateFormat.parse(s);
            return true;
        }
        catch (Exception e)
        {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

}
