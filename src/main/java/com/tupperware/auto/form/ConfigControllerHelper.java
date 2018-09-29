package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class ConfigControllerHelper extends BaseHelper {

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
				header.put("groupId", "");
				header.put("tableSchema", "");
				header.put("tableName", "");
				header.put("tableType", "");
				header.put("tableDesc", "");
				header.put("apiValue", "");
				header.put("notes", "");
				header.put("flag", "");
				header.put("producers", "");
				header.put("required", "");
				header.put("isdisabled", "");
				header.put("construct", "");
				header.put("ignored", "");
				header.put("requestPath", "");
				header.put("requestMethod", "");
				header.put("functionName", "");
				header.put("query", "");
				header.put("auth", "");
				header.put("updateDate", "");
		}
		return header;
	}
 



}
