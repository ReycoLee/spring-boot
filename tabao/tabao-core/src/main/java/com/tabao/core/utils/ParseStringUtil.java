/**
 * @(#)ParseStringUtil.java 1.0 2017年9月19日
 * @Copyright: Copyright 2010 - 2017 ISoftstone Co. Ltd. All Rights Reserved.
 * @Modification History:
 * @version: PROJNAME 1.0
 * @Date: 2017年9月19日
 * @Description: (Initialize)
 * @Reviewer:
 * @Review Date:
 */
package com.tabao.core.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * Description
 * 
 * @author LiQiang 126870
 */
public class ParseStringUtil
{
    public static <T> String toString(List<T> list)
    {
        return JSON.toJSONString(list);
    }
}
