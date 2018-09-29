package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class AuthRoleOperationHelper extends BaseHelper {

   /**
	 * header
	 */
	@JsonIgnore
    private static Map<String,String> header;


	@JsonIgnore
	public static Map<String, String> getHeader() {
		if(null==header) {
			header=new HashMap<>();
				header.put("roleid", "角色ID");
				header.put("opid", "权限ID");
		}
		return header;
	}
 



}
