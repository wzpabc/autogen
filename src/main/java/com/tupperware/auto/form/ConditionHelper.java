package com.tupperware.auto.form;

import com.tupperware.auto.generator.config.rules.NamingStrategy;

public class ConditionHelper {
	private String column;
	private String name;
	private String operator;
	private String value;
	private String strValue;
	private String seperator = "";
	private String endfix="";

	public String getName() {
		return NamingStrategy.underlineToCamel(name);
	}

	public void setName(String name) {

	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.name = column;
		this.column = column;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		this.strValue=value;
	}

	public String getStrValue() {
		return value.replaceAll("'","\"");
	}

	public String getSeperator() {
		return seperator;
	}

	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}

	public ConditionHelper(String column, String operator, String value, String seperator) {
		super();
		this.column = column;
		this.operator = operator;
		this.value = value;
		this.seperator = seperator;
		this.name = column;
	}

	public String getEndfix() {
		return endfix;
	}

	public void setEndfix(String endfix) {
		this.endfix = endfix;
	}

	@Override
	public int hashCode() {
		// 0
		int result = 11;
		result = result * 17 + (name == null ? 0 : name.hashCode());
		result = result * 17 + (column == null ? 0 : column.hashCode());
		// result=result*17+salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConditionHelper))
			return false;
		if (this == obj)
			return true;
		ConditionHelper instance = (ConditionHelper) obj;

		return name.equals(instance.name) && column.equals(instance.column);
	}
}
