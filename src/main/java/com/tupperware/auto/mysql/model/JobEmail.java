package com.tupperware.auto.mysql.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.alibaba.fastjson.annotation.JSONField;
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
 * @since 2018-12-26 11:16:15
 */
@TableName("job_email")
public class JobEmail extends Model<JobEmail> {

    private static final long serialVersionUID = 1L;       
	/**
     * 属性: mail
     * 备注: 
     * 字段: mail
	 */
	@JsonProperty
	private String mail;
	/**
     * 属性: execdate
     * 备注: 
     * 字段: execDate
	 */
	@JsonProperty
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //Jackson包使用注解
	private java.util.Date execdate;
	/**
     * 属性: nextexecdate
     * 备注: 
     * 字段: nextExecDate
	 */
	@JsonProperty
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //Jackson包使用注解
	private java.util.Date nextexecdate;
	/**
     * 属性: yearweek
     * 备注: 
     * 字段: YearWeek
	 */
	@JsonProperty
	private String yearweek;
	/**
     * 属性: organno
     * 备注: 
     * 字段: OrganNo
	 */
	@JsonProperty
	private String organno;
	/**
     * 属性: organname
     * 备注: 
     * 字段: organName
	 */
	@JsonProperty
	private String organname;
	/**
     * 属性: emailto
     * 备注: 
     * 字段: EmailTo
	 */
	@JsonProperty
	private String emailto;
	/**
     * 属性: emailcc
     * 备注: 
     * 字段: EmailCC
	 */
	@JsonProperty
	private String emailcc;
	/**
     * 属性: emailbc
     * 备注: 
     * 字段: EmailBC
	 */
	@JsonProperty
	private String emailbc;
	/**
     * 属性: subject
     * 备注: 
     * 字段: subject
	 */
	@JsonProperty
	private String subject;
	/**
     * 属性: content
     * 备注: 
     * 字段: content
	 */
	@JsonProperty
	private String content;
	/**
     * 属性: attpath
     * 备注: 
     * 字段: attPath
	 */
	@JsonProperty
	private String attpath;
	/**
     * 属性: isactive
     * 备注: 
     * 字段: isActive
	 */
	@JsonProperty
	private Integer isactive;
	/**
     * 属性: week
     * 备注: 
     * 字段: week
	 */
	@JsonProperty
	private String week;
	/**
     * 属性: quarter
     * 备注: 
     * 字段: quarter
	 */
	@JsonProperty
	private String quarter;
	/**
     * 属性: month
     * 备注: 
     * 字段: month
	 */
	@JsonProperty
	private String month;
	/**
     * 属性: year
     * 备注: 
     * 字段: year
	 */
	@JsonProperty
	private String year;
	/**
     * 属性: createtime
     * 备注: 
     * 字段: createTime
	 */
	@JsonProperty
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //Jackson包使用注解
	private java.util.Date createtime;
	/**
     * 属性: updatetime
     * 备注: 
     * 字段: updateTime
	 */
	@JsonProperty
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //Jackson包使用注解
	private java.util.Date updatetime;
	/**
     * 属性: deleteflag
     * 备注: 
     * 字段: deleteFlag
	 */
	@JsonProperty
	private Integer deleteflag;
	/**
     * 属性: id
     * 备注: 
     * 字段: id
	 */
	@TableId(type = IdType.AUTO,value="id")
	@JsonProperty
	private Integer id;
	/**
     * 属性: status
     * 备注: 
     * 字段: status
	 */
	@JsonProperty
	private Integer status;
	/**
     * 属性: type
     * 备注: 
     * 字段: type
	 */
	@JsonProperty
	private Integer type;

	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getMail() {
		return mail;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public java.util.Date getExecdate() {
		return execdate;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setExecdate(java.util.Date execdate) {
		this.execdate = execdate;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public java.util.Date getNextexecdate() {
		return nextexecdate;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setNextexecdate(java.util.Date nextexecdate) {
		this.nextexecdate = nextexecdate;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getYearweek() {
		return yearweek;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setYearweek(String yearweek) {
		this.yearweek = yearweek;
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
	public String getOrganname() {
		return organname;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setOrganname(String organname) {
		this.organname = organname;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getEmailto() {
		return emailto;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setEmailto(String emailto) {
		this.emailto = emailto;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getEmailcc() {
		return emailcc;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setEmailcc(String emailcc) {
		this.emailcc = emailcc;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getEmailbc() {
		return emailbc;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setEmailbc(String emailbc) {
		this.emailbc = emailbc;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getContent() {
		return content;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getAttpath() {
		return attpath;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setAttpath(String attpath) {
		this.attpath = attpath;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public Integer getIsactive() {
		return isactive;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getWeek() {
		return week;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getQuarter() {
		return quarter;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getMonth() {
		return month;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getYear() {
		return year;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public java.util.Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public java.util.Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public Integer getDeleteflag() {
		return deleteflag;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}
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
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public Integer getType() {
		return type;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setType(Integer type) {
		this.type = type;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  JobEmail() {
		//getHeader();
	}
	
}
