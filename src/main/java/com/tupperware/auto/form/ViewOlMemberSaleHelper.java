package com.tupperware.auto.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewOlMemberSaleHelper extends BaseHelper {
	String year;
	String month;
	String organno;

	/**
	 * header
	 */
	@JsonProperty
	private static Map<String, String> header;

	@JsonIgnore
	public static Map<String, String> getHeader() {
		if (null == header) {
			header = new HashMap<>();
			header.put("year", "年");
			header.put("month", "月");
			header.put("organNo", "编号");
			header.put("organName", "名称");
			header.put("organType", "类型");
			header.put("groupId", "组编号");
			header.put("paymentAmount", "金额");
			header.put("quantity", "数量");
			header.put("updateDate", "更新日期");
		}
		return header;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getOrganno() {
		return organno;
	}

	public void setOrganno(String organno) {
		this.organno = organno;
	}

	@Override
	public String toString() {
		return "ViewOlMemberSaleHelper [year=" + year + ", month=" + month + ", organno=" + organno + "]";
	}

}
