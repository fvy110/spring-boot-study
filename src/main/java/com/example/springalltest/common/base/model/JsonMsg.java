package com.example.springalltest.common.base.model;

import java.io.Serializable;

/**
 * 前后台信息交互类
 * 
 * @author Administrator
 */
public class JsonMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 是否成功
	 */
	private boolean success;

	/**
	 * 附带的数据
	 */
	private Object data;
	/**
	 * 附带的数据
	 */
	private String errorInfo;
	/**
	 * 无参构造方法
	 */

	public JsonMsg() {
		this.success = false;
		this.data = null;
		this.errorInfo = null;
	}

	/**
	 * 有参构造方法
	 * 
	 * @param success
	 * @param errorInfo
	 * @param data
	 */
	public JsonMsg(boolean success, Object data,String errorInfo) {
		this.success = success;
		this.data = data;
		this.errorInfo = errorInfo;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}
