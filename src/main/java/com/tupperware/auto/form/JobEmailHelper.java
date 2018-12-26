package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class JobEmailHelper extends BaseHelper {

   /**
	 * header
	 */
	@JsonIgnore
    private static Map<String,String> header;


	@JsonIgnore
	public static Map<String, String> getHeader() {
		if(null==header) {
			header=new HashMap<>();
				header.put("mail", "");
				header.put("execdate", "");
				header.put("nextexecdate", "");
				header.put("yearweek", "");
				header.put("organno", "");
				header.put("organname", "");
				header.put("emailto", "");
				header.put("emailcc", "");
				header.put("emailbc", "");
				header.put("subject", "");
				header.put("content", "");
				header.put("attpath", "");
				header.put("isactive", "");
				header.put("week", "");
				header.put("quarter", "");
				header.put("month", "");
				header.put("year", "");
				header.put("createtime", "");
				header.put("updatetime", "");
				header.put("deleteflag", "");
				header.put("id", "");
				header.put("status", "");
				header.put("type", "");
		}
		return header;
	}
 



}
