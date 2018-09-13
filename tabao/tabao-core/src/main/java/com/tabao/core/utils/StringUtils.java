package com.tabao.core.utils;

/**
 * String Utils
 * @author liqiang
 * @Date 2018-09-07
 */
public class StringUtils {
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return str == null || "".equals(str);
	}
	
	/**
	 * 判断不为空
	 * @param str
	 * @return
	 */
	public static boolean notBlank(String str) {
		return str != null && !"".equals(str);
	}
}
