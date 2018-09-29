package com.tupperware.auto.commons.utils;
 

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
 
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Miscellaneous utilities for web applications.
 * @author L.cm
 */
public class WebUtils extends org.springframework.web.util.WebUtils {
	/**
	 * 判断是否ajax请求
	 * spring ajax 返回含有 ResponseBody 或者 RestController注解
	 * @param handlerMethod HandlerMethod
	 * @return 是否ajax请求
	 */
	public static boolean isAjax(HandlerMethod handlerMethod) {
		ResponseBody responseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
		if (null != responseBody) {
			return true;
		}
		RestController restAnnotation = handlerMethod.getBean().getClass().getAnnotation(RestController.class);
		if (null != restAnnotation) {
			return true;
		}
		return false;
	}
	/**
	 * 把request数据装到javabean中的工具类
	 * @param request
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T Requst2Bean(HttpServletRequest request, Class<T> bean) {  
        T t = null;  
        try {  
        	//处理post请求中文乱码
        	request.setCharacterEncoding("utf-8");
            t = bean.newInstance();  
            Enumeration parameterNames = request.getParameterNames();  
            DateConverter convert = new DateConverter();//写一个日期转换器  
            String[] patterns = { "yyyyMMdd", "yyyy-MM-dd" };//限定日期的格式字符串数组  
            convert.setPatterns(patterns);  
            ConvertUtils.register(convert, Date.class);  
            while (parameterNames.hasMoreElements()) {  
                String name = (String) parameterNames.nextElement();  
                //处理Get请求中文乱码
                String value = new String(request.getParameter(name).getBytes("iso-8859-1"),"utf-8");                  
                System.out.println(value);
                System.out.println(name);
                BeanUtils.setProperty(t, name, value);//使用BeanUtils来设置对象属性的值  
  
            }  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return t;  
  
    }  
	/**
	 * 把request数据装到javabean中的工具类
	 * @param request
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String>  Requst2Map(HttpServletRequest request ) {  
		Map<String, String> map = Maps.newHashMap();  
        try {   
        	request.setCharacterEncoding("utf-8");
            Enumeration parameterNames = request.getParameterNames();  
            DateConverter convert = new DateConverter();//写一个日期转换器  
            String[] patterns = { "yyyyMMdd", "yyyy-MM-dd" };//限定日期的格式字符串数组  
            convert.setPatterns(patterns);  
            ConvertUtils.register(convert, Date.class);  
            while (parameterNames.hasMoreElements()) {  
                String name = (String) parameterNames.nextElement();  
                String value = new String(request.getParameter(name).getBytes("iso-8859-1"),"utf-8");   
                map.put(name, value);
  
            }  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        System.out.println(map.toString());
        return map;    
    }  
    /** 
* 将对象装换为map 
* @param bean 
* @return 
*/  
public static <T> Map<String, Object> beanToMap(T bean) {  
   Map<String, Object> map = Maps.newHashMap();  
   if (bean != null) {  
       BeanMap beanMap = BeanMap.create(bean);  
       for (Object key : beanMap.keySet()) {  
           map.put(key+"", beanMap.get(key));  
       }             
   }  
   return map;  
}  
 
/** 
* 将map装换为javabean对象 
* @param map 
* @param bean 
* @return 
*/  
public static <T> T mapToBean(Map<String, Object> map,T bean) {  
   BeanMap beanMap = BeanMap.create(bean);  
   beanMap.putAll(map);  
   return bean;  
}  
 
/** 
* 将List<T>转换为List<Map<String, Object>> 
* @param objList 
* @return 
* @throws JsonGenerationException 
* @throws JsonMappingException 
* @throws IOException 
*/  
public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {  
   List<Map<String, Object>> list = Lists.newArrayList();  
   if (objList != null && objList.size() > 0) {  
       Map<String, Object> map = null;  
       T bean = null;  
       for (int i = 0,size = objList.size(); i < size; i++) {  
           bean = objList.get(i);  
           map = beanToMap(bean);  
           list.add(map);  
       }  
   }  
   return list;  
}  
 
/** 
* 将List<Map<String,Object>>转换为List<T> 
* @param maps 
* @param clazz 
* @return 
* @throws InstantiationException 
* @throws IllegalAccessException 
*/  
public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps,Class<T> clazz) throws InstantiationException, IllegalAccessException {  
   List<T> list = Lists.newArrayList();  
   if (maps != null && maps.size() > 0) {  
       Map<String, Object> map = null;  
       T bean = null;  
       for (int i = 0,size = maps.size(); i < size; i++) {  
           map = maps.get(i);  
           bean = clazz.newInstance();  
           mapToBean(map, bean);  
           list.add(bean);  
       }  
   }  
   return list;  
}  
}
