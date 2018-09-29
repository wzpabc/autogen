package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class IArticleHelper extends BaseHelper {

   /**
	 * header
	 */
	@JsonIgnore
    private static Map<String,String> header;


	@JsonIgnore
	public static Map<String, String> getHeader() {
		if(null==header) {
			header=new HashMap<>();
				header.put("id", "发帖id");
				header.put("uid", "用户id");
				header.put("title", "标题");
				header.put("color", "标题颜色");
				header.put("cover", "封面");
				header.put("content", "内容");
				header.put("posttime", "发表时间");
		}
		return header;
	}
 



}
