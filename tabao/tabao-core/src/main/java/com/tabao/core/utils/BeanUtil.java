/*package com.tabao.core.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BeanUtil {
	
	protected static Logger logger = LoggerFactory.getLogger(BeanUtil.class);
	
	//把List中的对象转为map对象，返回List<Map>
	public static List<Map<String,Object>> convertMap(List<?> list){
    	List<Map<String,Object>> tagetList = new ArrayList<Map<String,Object>>();
    	for(Object origObj : list) {
        	Map<String,Object> destObj = new BeanMap(origObj);
        	tagetList.add(destObj);
    	}
    	return tagetList;		
	}
	
	public static Map<String, Object> beanToMap(Object obj) {   
        Map<String, Object> params = new HashMap<String, Object>(0);   
        try {   
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();   
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);   
            for (int i = 0; i < descriptors.length; i++) {   
                String name = descriptors[i].getName();   
                if (!StringUtils.equals(name, "class")) {   
                	Object valueObj = propertyUtilsBean.getNestedProperty(obj, name);
                	//如果属性为日期类型，且有JsonFormat.class注解，需转换
                	valueObj = BeanUtil.dateToString(obj,valueObj, name);
                    params.put(name, valueObj);
                }   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
        return params;   
	}  
	
	//日期类型转换为字符串类型，注意，必须属性上有JsonFormat.class注解
	public static Object dateToString(Object obj, Object fieldValue,String fieldName){
		Object rtnObj = fieldValue;
		Field field = null ;  
		if (fieldValue instanceof Date) {
        	for(Class<?> clazz = obj.getClass() ; clazz != Object.class ; clazz = clazz.getSuperclass()) {
				try {
					field = clazz.getDeclaredField(fieldName);
		        	if(field!=null){
		            	JsonFormat jsonFormat = field.getAnnotation(JsonFormat.class);
		            	if(jsonFormat!=null){
		            		String pattern = jsonFormat.pattern();
		            		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		            		return sdf.format(fieldValue);
		            	}
		        		DateTimeFormat df = field.getAnnotation(DateTimeFormat.class);
		        		if(df!=null){
		        			String pattern = df.pattern();
		        			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		            		return sdf.format(fieldValue);
		        		}
		        	}
				} catch (Exception e) {
					//e.printStackTrace();
				}
        	}
    	}			
		return rtnObj;
	}
	
}
*/