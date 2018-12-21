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
 * @since 2018-12-21
 */
@TableName("config_controller")
public class ConfigController extends Model<ConfigController> {

    private static final long serialVersionUID = 1L;       
	/**
     * 属性: id
     * 备注: 
     * 字段: id
	 */
	@JsonProperty
	private Integer id;
	/**
     * 属性: groupId
     * 备注: 
     * 字段: group_id
	 */
	@TableField(value="group_id")
	@JsonProperty
	private String groupId;
	/**
     * 属性: tableSchema
     * 备注: 
     * 字段: table_schema
	 */
	@TableField(value="table_schema")
	@JsonProperty
	private String tableSchema;
	/**
     * 属性: tableName
     * 备注: 
     * 字段: table_name
	 */
	@TableField(value="table_name")
	@JsonProperty
	private String tableName;
	/**
     * 属性: tableType
     * 备注: 
     * 字段: table_type
	 */
	@TableField(value="table_type")
	@JsonProperty
	private String tableType;
	/**
     * 属性: tableDesc
     * 备注: 
     * 字段: table_desc
	 */
	@TableField(value="table_desc")
	@JsonProperty
	private String tableDesc;
	/**
     * 属性: apiValue
     * 备注: 
     * 字段: api_value
	 */
	@TableField(value="api_value")
	@JsonProperty
	private String apiValue;
	/**
     * 属性: notes
     * 备注: 
     * 字段: notes
	 */
	@JsonProperty
	private String notes;
	/**
     * 属性: flag
     * 备注: 
     * 字段: flag
	 */
	@JsonProperty
	private String flag;
	/**
     * 属性: producers
     * 备注: 
     * 字段: producers
	 */
	@JsonProperty
	private String producers;
	/**
     * 属性: required
     * 备注: 
     * 字段: required
	 */
	@JsonProperty
	private String required;
	/**
     * 属性: isdisabled
     * 备注: 
     * 字段: isdisabled
	 */
	@JsonProperty
	private Integer isdisabled;
	/**
     * 属性: construct
     * 备注: 
     * 字段: construct
	 */
	@JsonProperty
	private String construct;
	/**
     * 属性: ignored
     * 备注: 
     * 字段: ignored
	 */
	@JsonProperty
	private Integer ignored;
	/**
     * 属性: requestPath
     * 备注: 
     * 字段: request_path
	 */
	@TableField(value="request_path")
	@JsonProperty
	private String requestPath;
	/**
     * 属性: requestMethod
     * 备注: 
     * 字段: request_method
	 */
	@TableField(value="request_method")
	@JsonProperty
	private String requestMethod;
	/**
     * 属性: functionName
     * 备注: 
     * 字段: function_name
	 */
	@TableField(value="function_name")
	@JsonProperty
	private String functionName;
	/**
     * 属性: query
     * 备注: 
     * 字段: query
	 */
	@JsonProperty
	private String query;
	/**
     * 属性: auth
     * 备注: 
     * 字段: auth
	 */
	@JsonProperty
	private Integer auth;
	/**
     * 属性: updateDate
     * 备注: 
     * 字段: update_date
	 */
	@TableField(value="update_date")
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateDate;

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
	public String getGroupId() {
		return groupId;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getTableSchema() {
		return tableSchema;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getTableName() {
		return tableName;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getTableType() {
		return tableType;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getTableDesc() {
		return tableDesc;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getApiValue() {
		return apiValue;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setApiValue(String apiValue) {
		this.apiValue = apiValue;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getNotes() {
		return notes;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getFlag() {
		return flag;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getProducers() {
		return producers;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setProducers(String producers) {
		this.producers = producers;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getRequired() {
		return required;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setRequired(String required) {
		this.required = required;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public Integer getIsdisabled() {
		return isdisabled;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setIsdisabled(Integer isdisabled) {
		this.isdisabled = isdisabled;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getConstruct() {
		return construct;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setConstruct(String construct) {
		this.construct = construct;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public Integer getIgnored() {
		return ignored;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setIgnored(Integer ignored) {
		this.ignored = ignored;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getRequestPath() {
		return requestPath;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getRequestMethod() {
		return requestMethod;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getFunctionName() {
		return functionName;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public String getQuery() {
		return query;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setQuery(String query) {
		this.query = query;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public Integer getAuth() {
		return auth;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setAuth(Integer auth) {
		this.auth = auth;
	}
	/**
	 * 获取 
	 */
	@JsonIgnore
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置 
	 */
	@JsonIgnore
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

 

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  ConfigController() {
		//getHeader();
	}
	
}
