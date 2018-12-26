package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class ApiuserHelper extends BaseHelper {

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
				header.put("username", "");
				header.put("password", "");
				header.put("nickname", "");
				header.put("organno", "");
				header.put("jdeno", "");
		}
		return header;
	}
 



}
