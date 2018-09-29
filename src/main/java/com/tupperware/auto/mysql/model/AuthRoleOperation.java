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
 * 角色权限关系表 实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
@TableName("auth_role_operation")
public class AuthRoleOperation extends Model<AuthRoleOperation> {

    private static final long serialVersionUID = 1L;       
	/**
     * 属性: roleid
     * 备注: 角色ID
     * 字段: roleid
	 */
	@TableId(type = IdType.AUTO,value="roleid")
	@JsonProperty
	private Integer roleid;
	/**
     * 属性: opid
     * 备注: 权限ID
     * 字段: opid
	 */
	@JsonProperty
	private Integer opid;

	/**
	 * 获取 角色ID
	 */
	@JsonIgnore
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 设置 角色ID
	 */
	@JsonIgnore
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获取 权限ID
	 */
	@JsonIgnore
	public Integer getOpid() {
		return opid;
	}
	/**
	 * 设置 权限ID
	 */
	@JsonIgnore
	public void setOpid(Integer opid) {
		this.opid = opid;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  AuthRoleOperation() {
		//getHeader();
	}
	
}
