package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class AuthOperationHelper extends BaseHelper {

   /**
	 * header
	 */
	@JsonIgnore
    private static Map<String,String> header;


	@JsonIgnore
	public static Map<String, String> getHeader() {
		if(null==header) {
			header=new HashMap<>();
				header.put("opid", "主键");
				header.put("opcode", "权限值");
				header.put("opname", "权限名称");
				header.put("ophref", "权限操作链接");
				header.put("opseq", "显示顺序");
		}
		return header;
	}
 



}
