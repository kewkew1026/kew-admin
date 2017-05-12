package com.kew.boss.model;

/**
 * Result对象
 * @author mark
 *
 */
public class Result {
	/**
	 * 对象
	 */
	private Object object;
	/**
	 * 信息
	 */
	private String msg;
	/**
	 * 成功信息
	 */
	private String success;
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
}
