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
 * 系统日志表 实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
@TableName("i_log")
public class ILog extends Model<ILog> {

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
     * 属性: username
     * 备注: 操作用户
     * 字段: username
	 */
	@JsonProperty
	private String username;
	/**
     * 属性: type
     * 备注: 操作类型(0操作日志;1异常日志)
     * 字段: type
	 */
	@JsonProperty
	private Integer type;
	/**
     * 属性: url
     * 备注: 请求地址
     * 字段: url
	 */
	@JsonProperty
	private String url;
	/**
     * 属性: method
     * 备注: 执行方法
     * 字段: method
	 */
	@JsonProperty
	private String method;
	/**
     * 属性: params
     * 备注: 请求参数
     * 字段: params
	 */
	@JsonProperty
	private String params;
	/**
     * 属性: requestip
     * 备注: 请求IP
     * 字段: requestip
	 */
	@JsonProperty
	private String requestip;
	/**
     * 属性: description
     * 备注: 操作描述
     * 字段: description
	 */
	@JsonProperty
	private String description;
	/**
     * 属性: detail
     * 备注: 异常详情
     * 字段: detail
	 */
	@JsonProperty
	private String detail;
	/**
     * 属性: operDate
     * 备注: 操作日期
     * 字段: oper_date
	 */
	@TableField(value="oper_date")
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date operDate;

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
	 * 获取 操作用户
	 */
	@JsonIgnore
	public String getUsername() {
		return username;
	}
	/**
	 * 设置 操作用户
	 */
	@JsonIgnore
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取 操作类型(0操作日志;1异常日志)
	 */
	@JsonIgnore
	public Integer getType() {
		return type;
	}
	/**
	 * 设置 操作类型(0操作日志;1异常日志)
	 */
	@JsonIgnore
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取 请求地址
	 */
	@JsonIgnore
	public String getUrl() {
		return url;
	}
	/**
	 * 设置 请求地址
	 */
	@JsonIgnore
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取 执行方法
	 */
	@JsonIgnore
	public String getMethod() {
		return method;
	}
	/**
	 * 设置 执行方法
	 */
	@JsonIgnore
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取 请求参数
	 */
	@JsonIgnore
	public String getParams() {
		return params;
	}
	/**
	 * 设置 请求参数
	 */
	@JsonIgnore
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取 请求IP
	 */
	@JsonIgnore
	public String getRequestip() {
		return requestip;
	}
	/**
	 * 设置 请求IP
	 */
	@JsonIgnore
	public void setRequestip(String requestip) {
		this.requestip = requestip;
	}
	/**
	 * 获取 操作描述
	 */
	@JsonIgnore
	public String getDescription() {
		return description;
	}
	/**
	 * 设置 操作描述
	 */
	@JsonIgnore
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取 异常详情
	 */
	@JsonIgnore
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置 异常详情
	 */
	@JsonIgnore
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取 操作日期
	 */
	@JsonIgnore
	public java.util.Date getOperDate() {
		return operDate;
	}
	/**
	 * 设置 操作日期
	 */
	@JsonIgnore
	public void setOperDate(java.util.Date operDate) {
		this.operDate = operDate;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  ILog() {
		//getHeader();
	}
	
}
