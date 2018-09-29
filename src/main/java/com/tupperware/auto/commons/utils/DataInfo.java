package com.tupperware.auto.commons.utils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 返回报表数据
 * 
 * @author upw023
 *
 */
@SuppressWarnings("rawtypes")
public class DataInfo {

	private int total; // 总记录

	private String organno;
	@JsonIgnore
	private String organtype;
	private String dimtime;
	private String dimorgan;
	private List rows; // 显示的记录

	private String message;
	private int code;
	private boolean status;

	private String datetime = VeDate.getStringDate();
	private String sqlSegment="";

	public String getSqlSegment() {
		return sqlSegment;
	}

	public void setSqlSegment(String sqlSegment) {
		this.sqlSegment = sqlSegment;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public DataInfo() {
		super();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getOrganno() {
		return organno;
	}

	public void setOrganno(String organno) {
		this.organno = organno;
	}

	public String getOrgantype() {
		return organtype;
	}

	public void setOrgantype(String organtype) {
		this.organtype = organtype;
	}

	public String getDimtime() {
		return dimtime;
	}

	public void setDimtime(String dimtime) {
		this.dimtime = dimtime;
	}

	public String getDimorgan() {
		return dimorgan;
	}

	public void setDimorgan(String dimorgan) {
		this.dimorgan = dimorgan;
	}

	public DataInfo(String organno, String dimtime, String dimorgan) {

		this.organno = organno;
		this.dimtime = dimtime;
		this.dimorgan = dimorgan;
	}

	public DataInfo(String organno, String dimtime) {

		this.organno = organno;
		this.dimtime = dimtime;
	}

	public DataInfo(String organno) {

		this.organno = organno;
		this.dimtime = "";
		this.dimorgan = "";
	}

	public DataInfo(String desc, String organno, String dimtime, String dimorgan) {
		super();
		this.organno = organno;
		this.dimtime = dimtime;
		this.dimorgan = dimorgan;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DataInfo [total=" + total + ", organno=" + organno + ", organtype=" + organtype + ", dimtime=" + dimtime
				+ ", dimorgan=" + dimorgan + ", rows=" + rows + ", message=" + message + ", code=" + code + ", status="
				+ status + ", datetime=" + datetime + ", sqlSegment=" + sqlSegment + "]";
	}

}
