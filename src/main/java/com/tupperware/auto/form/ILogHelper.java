package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class ILogHelper extends BaseHelper {

   /**
	 * header
	 */
	@JsonIgnore
    private static Map<String,String> header;


	@JsonIgnore
	public static Map<String, String> getHeader() {
		if(null==header) {
			header=new HashMap<>();
				header.put("id", "");
				header.put("username", "操作用户");
				header.put("type", "操作类型(0操作日志;1异常日志)");
				header.put("url", "请求地址");
				header.put("method", "执行方法");
				header.put("params", "请求参数");
				header.put("requestip", "请求IP");
				header.put("description", "操作描述");
				header.put("detail", "异常详情");
				header.put("operDate", "操作日期");
		}
		return header;
	}
 



}
