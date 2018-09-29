package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrganGoliveHelper extends BaseHelper {

   /**
	 * header
	 */
	@JsonIgnore
    private static Map<String,String> header;


	@JsonIgnore
	public static Map<String, String> getHeader() {
		if(null==header) {
			header=new HashMap<>();
				header.put("organNo", "编码");
				header.put("organName", "客户名称");
				header.put("jdeId", "JDE编码");
				header.put("organType", "类型");
				header.put("effectDate", "生效日期");
				header.put("isFmsid", "是否fmsid");
		}
		return header;
	}
 



}
