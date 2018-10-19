package com.example.springalltest.common.base.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 前端easyUI datagrid模型类
 * 
 * @author Administrator
 *
 * @param <T>
 */
@XmlRootElement
public class GridListJson<T> implements Serializable {

	/** 描述 */

	private static final long serialVersionUID = 5588762107688840821L;

	/**
	 * 是否成功
	 */
	private boolean success;
	/**
	 * 数据
	 */
	private List<T> rows;
	/**
	 * 总页数
	 */
	private long total;
	/**
	 * 附带的数据
	 */
	private Object data;
	/**
	 * 附带的信息
	 */
	private String message;

	public GridListJson() {
		this.success = false;
		this.message = null;
		this.total = 0L;
		this.rows = new ArrayList<T>();
		this.data = null;
	}

	public GridListJson(boolean success, String message, long total, List<T> rows, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.total = total;
		this.rows = rows;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	public String getMessage() {
		return message;
	}
	@XmlElement
	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotal() {
		return total;
	}
	@XmlElement
	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	

}
