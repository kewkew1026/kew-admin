package com.kew.boss.model;

import java.util.Date;

public class SysLog {
	/**
	 * 日志ID
	 */
	private String logId;
	/**
	 * 操作者ID
	 */
	private String operCode;
	/**
	 * 操作时间
	 */
	private Date operTime;
	/**
	 * IP地址/机顶盒ID
	 */
	private String objectId;
	/**
	 * 功能ID
	 */
	private String funId;
	/**
	 * 功能地址
	 */
	private String funUrl;
	/**
	 * 内容
	 */
	private String funContent;
	/**
	 * 验证码
	 */
	private String serCode;
	
	/**
	 * 参数
	 */
	private String param;
	
	/**
	 * 起始时间
	 */
	private Date startDate;
	
	/**
	 * 结束时间
	 */
	private Date endDate;
	
	/**
	 * 辅助字段
	 */
	private String myStartDate;
	
	private String myEndDate;
	
	public String getMyStartDate() {
		return myStartDate;
	}
	public void setMyStartDate(String myStartDate) {
		this.myStartDate = myStartDate;
	}
	public String getMyEndDate() {
		return myEndDate;
	}
	public void setMyEndDate(String myEndDate) {
		this.myEndDate = myEndDate;
	}
	/**
	 * 辅助字段
	 * 
	 * @return
	 */
	private String myOperTime;
	
	public String getMyOperTime() {
		return myOperTime;
	}
	public void setMyOperTime(String myOperTime) {
		this.myOperTime = myOperTime;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getOperCode() {
		return operCode;
	}
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	public Date getOperTime() {
		return operTime;
	}
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getFunId() {
		return funId;
	}
	public void setFunId(String funId) {
		this.funId = funId;
	}
	public String getFunUrl() {
		return funUrl;
	}
	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}
	public String getFunContent() {
		return funContent;
	}
	public void setFunContent(String funContent) {
		this.funContent = funContent;
	}
	public String getSerCode() {
		return serCode;
	}
	public void setSerCode(String serCode) {
		this.serCode = serCode;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
