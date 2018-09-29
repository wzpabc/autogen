package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tupperware.auto.form.BaseHelper;

public class IFileHelper extends BaseHelper {

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
				header.put("filename", "文件原名");
				header.put("nowname", "文件名称");
				header.put("savepath", "存放位置");
				header.put("url", "访问地址");
				header.put("filetype", "文件类型");
				header.put("filesize", "文件大小(字节)");
				header.put("addtime", "上传时间");
		}
		return header;
	}
 



}
