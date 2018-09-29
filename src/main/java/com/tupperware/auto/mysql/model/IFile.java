package com.tupperware.auto.mysql.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
/**
 * <p>
 * 上传的文件信息 实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
@TableName("i_file")
public class IFile extends Model<IFile> {

    private static final long serialVersionUID = 1L;       
	/**
     * 属性: id
     * 备注: 
     * 字段: id
	 */
	@TableId(type = IdType.AUTO,value="id")
	@JsonProperty
	private Integer id;
	/**
     * 属性: filename
     * 备注: 文件原名
     * 字段: filename
	 */
	@JsonProperty
	private String filename;
	/**
     * 属性: nowname
     * 备注: 文件名称
     * 字段: nowname
	 */
	@JsonProperty
	private String nowname;
	/**
     * 属性: savepath
     * 备注: 存放位置
     * 字段: savepath
	 */
	@JsonProperty
	private String savepath;
	/**
     * 属性: url
     * 备注: 访问地址
     * 字段: url
	 */
	@JsonProperty
	private String url;
	/**
     * 属性: filetype
     * 备注: 文件类型
     * 字段: filetype
	 */
	@JsonProperty
	private String filetype;
	/**
     * 属性: filesize
     * 备注: 文件大小(字节)
     * 字段: filesize
	 */
	@JsonProperty
	private Long filesize;
	/**
     * 属性: addtime
     * 备注: 上传时间
     * 字段: addtime
	 */
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date addtime;

	/**
	 * 获取 
	 */
	@JsonIgnore
	public Integer getId() {
		return id;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取 文件原名
	 */
	@JsonIgnore
	public String getFilename() {
		return filename;
	}
	/**
	 * 设置 文件原名
	 */
	@JsonIgnore
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * 获取 文件名称
	 */
	@JsonIgnore
	public String getNowname() {
		return nowname;
	}
	/**
	 * 设置 文件名称
	 */
	@JsonIgnore
	public void setNowname(String nowname) {
		this.nowname = nowname;
	}
	/**
	 * 获取 存放位置
	 */
	@JsonIgnore
	public String getSavepath() {
		return savepath;
	}
	/**
	 * 设置 存放位置
	 */
	@JsonIgnore
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	/**
	 * 获取 访问地址
	 */
	@JsonIgnore
	public String getUrl() {
		return url;
	}
	/**
	 * 设置 访问地址
	 */
	@JsonIgnore
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取 文件类型
	 */
	@JsonIgnore
	public String getFiletype() {
		return filetype;
	}
	/**
	 * 设置 文件类型
	 */
	@JsonIgnore
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	/**
	 * 获取 文件大小(字节)
	 */
	@JsonIgnore
	public Long getFilesize() {
		return filesize;
	}
	/**
	 * 设置 文件大小(字节)
	 */
	@JsonIgnore
	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}
	/**
	 * 获取 上传时间
	 */
	@JsonIgnore
	public java.util.Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置 上传时间
	 */
	@JsonIgnore
	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  IFile() {
		//getHeader();
	}
	
}
