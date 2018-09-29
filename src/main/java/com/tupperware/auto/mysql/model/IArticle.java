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
 * 文章信息表 实体类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
@TableName("i_article")
public class IArticle extends Model<IArticle> {

    private static final long serialVersionUID = 1L;       
	/**
     * 属性: id
     * 备注: 发帖id
     * 字段: id
	 */
	@TableId(type = IdType.AUTO,value="id")
	@JsonProperty
	private Long id;
	/**
     * 属性: uid
     * 备注: 用户id
     * 字段: uid
	 */
	@JsonProperty
	private Integer uid;
	/**
     * 属性: title
     * 备注: 标题
     * 字段: title
	 */
	@JsonProperty
	private String title;
	/**
     * 属性: color
     * 备注: 标题颜色
     * 字段: color
	 */
	@JsonProperty
	private String color;
	/**
     * 属性: cover
     * 备注: 封面
     * 字段: cover
	 */
	@JsonProperty
	private String cover;
	/**
     * 属性: content
     * 备注: 内容
     * 字段: content
	 */
	@JsonProperty
	private String content;
	/**
     * 属性: posttime
     * 备注: 发表时间
     * 字段: posttime
	 */
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date posttime;

	/**
	 * 获取 发帖id
	 */
	@JsonIgnore
	public Long getId() {
		return id;
	}
	/**
	 * 设置 发帖id
	 */
	@JsonIgnore
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取 用户id
	 */
	@JsonIgnore
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置 用户id
	 */
	@JsonIgnore
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取 标题
	 */
	@JsonIgnore
	public String getTitle() {
		return title;
	}
	/**
	 * 设置 标题
	 */
	@JsonIgnore
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取 标题颜色
	 */
	@JsonIgnore
	public String getColor() {
		return color;
	}
	/**
	 * 设置 标题颜色
	 */
	@JsonIgnore
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 获取 封面
	 */
	@JsonIgnore
	public String getCover() {
		return cover;
	}
	/**
	 * 设置 封面
	 */
	@JsonIgnore
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * 获取 内容
	 */
	@JsonIgnore
	public String getContent() {
		return content;
	}
	/**
	 * 设置 内容
	 */
	@JsonIgnore
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取 发表时间
	 */
	@JsonIgnore
	public java.util.Date getPosttime() {
		return posttime;
	}
	/**
	 * 设置 发表时间
	 */
	@JsonIgnore
	public void setPosttime(java.util.Date posttime) {
		this.posttime = posttime;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  IArticle() {
		//getHeader();
	}
	
}
