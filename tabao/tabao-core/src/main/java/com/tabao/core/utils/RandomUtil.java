package com.tabao.core.utils;

/**
 * Created by issuser on 2017/7/13.
 */

import java.util.List;
import java.util.Random;

/**
 * Description
 *
 * @author yyxiangf 126979
 */

public class RandomUtil
{
    private static Random random;

    // 双重校验锁获取一个Random单例
    public static Random getRandom()
    {
        if (random == null)
        {
            synchronized (RandomUtil.class)
            {
                if (random == null)
                {
                    random = new Random();
                }
            }
        }

        return random;
    }

    /**
     * 获得一个[0,max)之间的整数。
     * 
     * @param max
     * @return
     */
    public static int getRandomInt(int max)
    {
        return Math.abs(getRandom().nextInt()) % max;
    }

    /**
     * 获得一个[0,max)之间的整数。
     * 
     * @param max
     * @return
     */
    public static long getRandomLong(long max)
    {
        return Math.abs(getRandom().nextInt()) % max;
    }

    /**
     * 从list中随机取得一个元素
     * 
     * @param list
     * @return
     */
    public static <T> T getRandomElement(List<T> list)
    {
        return list.get(getRandomInt(list.size()));
    }
}
