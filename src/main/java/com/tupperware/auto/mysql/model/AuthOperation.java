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
 * 权限信息表 实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
@TableName("auth_operation")
public class AuthOperation extends Model<AuthOperation> {

    private static final long serialVersionUID = 1L;       
	/**
     * 属性: opid
     * 备注: 主键
     * 字段: opid
	 */
	@TableId(type = IdType.AUTO,value="opid")
	@JsonProperty
	private Integer opid;
	/**
     * 属性: opcode
     * 备注: 权限值
     * 字段: opcode
	 */
	@JsonProperty
	private String opcode;
	/**
     * 属性: opname
     * 备注: 权限名称
     * 字段: opname
	 */
	@JsonProperty
	private String opname;
	/**
     * 属性: ophref
     * 备注: 权限操作链接
     * 字段: ophref
	 */
	@JsonProperty
	private String ophref;
	/**
     * 属性: opseq
     * 备注: 显示顺序
     * 字段: opseq
	 */
	@JsonProperty
	private Integer opseq;

	/**
	 * 获取 主键
	 */
	@JsonIgnore
	public Integer getOpid() {
		return opid;
	}
	/**
	 * 设置 主键
	 */
	@JsonIgnore
	public void setOpid(Integer opid) {
		this.opid = opid;
	}
	/**
	 * 获取 权限值
	 */
	@JsonIgnore
	public String getOpcode() {
		return opcode;
	}
	/**
	 * 设置 权限值
	 */
	@JsonIgnore
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	/**
	 * 获取 权限名称
	 */
	@JsonIgnore
	public String getOpname() {
		return opname;
	}
	/**
	 * 设置 权限名称
	 */
	@JsonIgnore
	public void setOpname(String opname) {
		this.opname = opname;
	}
	/**
	 * 获取 权限操作链接
	 */
	@JsonIgnore
	public String getOphref() {
		return ophref;
	}
	/**
	 * 设置 权限操作链接
	 */
	@JsonIgnore
	public void setOphref(String ophref) {
		this.ophref = ophref;
	}
	/**
	 * 获取 显示顺序
	 */
	@JsonIgnore
	public Integer getOpseq() {
		return opseq;
	}
	/**
	 * 设置 显示顺序
	 */
	@JsonIgnore
	public void setOpseq(Integer opseq) {
		this.opseq = opseq;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  AuthOperation() {
		//getHeader();
	}
	
}
