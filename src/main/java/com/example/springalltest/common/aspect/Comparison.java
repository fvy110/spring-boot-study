package com.example.springalltest.common.aspect;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 
 * 
 * 对照实体
 */
public class Comparison {
	// 字段
	private String field;
	// 名称
	private String fieldName;
	// 字段类型
	private Class<?> fieldType;
	// 之前
	private Object before;
	// 之后
	private Object after;

	public String getField() {
		return field;
	}

	void setField(String field) {
		this.field = field;
	}

	public String getFieldName() {
		return fieldName;
	}

	void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Class<?> getFieldType() {
		return fieldType;
	}

	void setFieldType(Class<?> fieldType) {
		this.fieldType = fieldType;
	}

	public Object getBefore() {
		return before;
	}

	void setBefore(Object before) {
		this.before = before;
	}

	public Object getAfter() {
		return after;
	}

	void setAfter(Object after) {
		this.after = after;
	}

	boolean isdifferent() {
		if (before == null && after == null) {
			return true;
		}
		if (before == null || after == null) {
			return false;
		}
		if (fieldType.isAssignableFrom(Integer.class)) {
			return ((Integer) before).equals((Integer) after);
		} else if (fieldType.isAssignableFrom(Boolean.class)) {
			return ((Boolean) before).equals((Boolean) after);
		} else if (fieldType.isAssignableFrom(Long.class)) {
			return ((Long) before).equals((Long) after);
		} else if (fieldType.isAssignableFrom(java.util.Date.class)
				|| fieldType.isAssignableFrom(Date.class)) {
			return ((java.util.Date) before).compareTo((java.util.Date) after) == 0;
		} else if (fieldType.isAssignableFrom(Timestamp.class)) {
			return ((Timestamp) before).compareTo((Timestamp) after) == 0;
		} else {
			return ((String) before).equals((String) after);
		}
	}

	public String getBeforeStirng() {
		return objtostr(before);
	}

	public String getAfterString() {
		return objtostr(after);
	}

	private String objtostr(Object obj) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		if (fieldType.isAssignableFrom(Integer.class)
				|| fieldType.isAssignableFrom(Long.class)) {
			return (String) obj;
		} else if (fieldType.isAssignableFrom(Boolean.class)) {
			return (((Boolean) obj) ? "1" : "0");
		} else if (fieldType.isAssignableFrom(java.util.Date.class)
				|| fieldType.isAssignableFrom(Date.class)) {
			return formatter.format((java.util.Date) obj);
		} else if (fieldType.isAssignableFrom(Timestamp.class)) {
			return formatter.format((Timestamp) obj);
		} else {
			return (String) obj;
		}
	}
}
