package com.tupperware.auto.mysql.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
/**
 * <p>
 *  实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-12-26 11:16:15
 */
public class Apiuser extends Model<Apiuser> {

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
     * 备注: 
     * 字段: username
	 */
	@JsonProperty
	private String username;
	/**
     * 属性: password
     * 备注: 
     * 字段: password
	 */
	@JsonProperty
	private String password;
	/**
     * 属性: nickname
     * 备注: 
     * 字段: nickname
	 */
	@JsonProperty
	private String nickname;
	/**
     * 属性: organno
     * 备注: 
     * 字段: organno
	 */
	@JsonProperty
	private String organno;
	/**
     * 属性: jdeno
     * 备注: 
     * 字段: jdeno
	 */
	@JsonProperty
	private String jdeno;

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
	 * 获取 
	 */
	@JsonIgnore
	public String getUsername() {
		return username;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getOrganno() {
		return organno;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setOrganno(String organno) {
		this.organno = organno;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getJdeno() {
		return jdeno;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setJdeno(String jdeno) {
		this.jdeno = jdeno;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  Apiuser() {
		//getHeader();
	}
	
}
