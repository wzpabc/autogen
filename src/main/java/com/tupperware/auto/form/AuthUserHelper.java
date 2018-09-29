package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class AuthUserHelper extends BaseHelper {

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
				header.put("email", "");
				header.put("useable", "是否可用(0禁用,1可用)");
				header.put("roleid", "所属角色");
				header.put("addtime", "创建时间");
				header.put("logintime", "登陆时间");
				header.put("loginip", "登陆IP");
		}
		return header;
	}
 



}
