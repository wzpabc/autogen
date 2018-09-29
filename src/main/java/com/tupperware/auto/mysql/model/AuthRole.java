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
 * 角色信息表 实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
@TableName("auth_role")
public class AuthRole extends Model<AuthRole> {

    private static final long serialVersionUID = 1L;       
	/**
     * 属性: roleid
     * 备注: 主键
     * 字段: roleid
	 */
	@TableId(type = IdType.AUTO,value="roleid")
	@JsonProperty
	private Integer roleid;
	/**
     * 属性: rolename
     * 备注: 角色名称
     * 字段: rolename
	 */
	@JsonProperty
	private String rolename;
	/**
     * 属性: cname
     * 备注: 中文名
     * 字段: cname
	 */
	@JsonProperty
	private String cname;

	/**
	 * 获取 主键
	 */
	@JsonIgnore
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 设置 主键
	 */
	@JsonIgnore
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获取 角色名称
	 */
	@JsonIgnore
	public String getRolename() {
		return rolename;
	}
	/**
	 * 设置 角色名称
	 */
	@JsonIgnore
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	/**
	 * 获取 中文名
	 */
	@JsonIgnore
	public String getCname() {
		return cname;
	}
	/**
	 * 设置 中文名
	 */
	@JsonIgnore
	public void setCname(String cname) {
		this.cname = cname;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  AuthRole() {
		//getHeader();
	}
	
}
