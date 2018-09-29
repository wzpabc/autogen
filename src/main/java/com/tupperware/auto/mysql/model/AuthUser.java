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
 *  实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
@TableName("auth_user")
public class AuthUser extends Model<AuthUser> {

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
     * 属性: email
     * 备注: 
     * 字段: email
	 */
	@JsonProperty
	private String email;
	/**
     * 属性: useable
     * 备注: 是否可用(0禁用,1可用)
     * 字段: useable
	 */
	@JsonProperty
	private Integer useable;
	/**
     * 属性: roleid
     * 备注: 所属角色
     * 字段: roleid
	 */
	@JsonProperty
	private Integer roleid;
	/**
     * 属性: addtime
     * 备注: 创建时间
     * 字段: addtime
	 */
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date addtime;
	/**
     * 属性: logintime
     * 备注: 登陆时间
     * 字段: logintime
	 */
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date logintime;
	/**
     * 属性: loginip
     * 备注: 登陆IP
     * 字段: loginip
	 */
	@JsonProperty
	private String loginip;

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
	public String getEmail() {
		return email;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取 是否可用(0禁用,1可用)
	 */
	@JsonIgnore
	public Integer getUseable() {
		return useable;
	}
	/**
	 * 设置 是否可用(0禁用,1可用)
	 */
	@JsonIgnore
	public void setUseable(Integer useable) {
		this.useable = useable;
	}
	/**
	 * 获取 所属角色
	 */
	@JsonIgnore
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 设置 所属角色
	 */
	@JsonIgnore
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获取 创建时间
	 */
	@JsonIgnore
	public java.util.Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置 创建时间
	 */
	@JsonIgnore
	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取 登陆时间
	 */
	@JsonIgnore
	public java.util.Date getLogintime() {
		return logintime;
	}
	/**
	 * 设置 登陆时间
	 */
	@JsonIgnore
	public void setLogintime(java.util.Date logintime) {
		this.logintime = logintime;
	}
	/**
	 * 获取 登陆IP
	 */
	@JsonIgnore
	public String getLoginip() {
		return loginip;
	}
	/**
	 * 设置 登陆IP
	 */
	@JsonIgnore
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  AuthUser() {
		//getHeader();
	}
	
}
