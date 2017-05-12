/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * Menue.java
 */
package com.kew.boss.model;

/**
 * [文件名称]<br>
 * Menue <br>
 * <br>
 * [文件描述]<br>
 * 菜单model<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-4 ver1.00 创建 ji_qingyang<br>
 * 
 * @author ji_qingyang
 * @version 1.00
 */
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Menue extends TreeMenue implements Serializable {
	/**
	 * 实序列id
	 */
	private static final long serialVersionUID = 6924301083653730949L;

	/**
	 * 菜单ID.
	 */
	private long menueId;
	/**
	 * 菜单名称.
	 */
	private String menueNm;
	/**
	 * 功能操作ID.
	 */
	private long funOptId;

	/**
	 * 父菜单id.
	 */
	private long parMenueId;

	/**
	 * 备注.
	 */
	private String remarks;
	
	/**
	 * 状态.
	 */
	private String state;
	/**
	 * 菜单顺序.
	 */
	private long menueOrder;
	/**
	 * 操作用户.
	 */
	private long staffId;
	/**
	 * 状态修改时间.
	 */
	private Date stateUpdtTime;
	
	/**
	 * 菜单url.
	 */
	private  String menueUrl;
	
	/**
	 * 子菜单list.
	 */
	private List<Menue> childrenMenueList;
	
    /**
     * 获取菜单id
     * 
     * @return 菜单id
     */
	public long getMenueId() {
		return menueId;
	}
	
    /**
     * 设置菜单id
     * 
     * @param menueId
     *            菜单id
     */
	public void setMenueId(long menueId) {
		this.menueId = menueId;
	}
	
    /**
     * 获取菜单名称
     * 
     * @return 菜单名称
     */
	public String getMenueNm() {
		return menueNm;
	}
	
    /**
     * 设置菜单名称
     * 
     * @param menueNm
     *            菜单名称
     */
	public void setMenueNm(String menueNm) {
		this.menueNm = menueNm;
	}
	
    /**
     * 获取菜单功能操作id
     * 
     * @return 菜单功能操作id
     */
	public long getFunOptId() {
		return funOptId;
	}
	
    /**
     * 设置菜单功能操作id
     * 
     * @param funOptId
     *            菜单功能操作id
     */
	public void setFunOptId(long funOptId) {
		this.funOptId = funOptId;
	}
	
    /**
     * 获取菜单父菜单id
     * 
     * @return 菜单父菜单id
     */
	public long getParMenueId() {
		return parMenueId;
	}
	
    /**
     * 设置菜单父菜单id
     * 
     * @param parMenueId
     *            菜单父菜单id
     */
	public void setParMenueId(long parMenueId) {
		this.parMenueId = parMenueId;
	}
	
    /**
     * 获取菜单备注
     * 
     * @return 菜单备注
     */
	public String getRemarks() {
		return remarks;
	}
	
    /**
     * 设置菜单备注
     * 
     * @param remarks
     *            菜单备注
     */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
    /**
     * 获取菜单状态
     * 
     * @return 菜单状态
     */
	public String getState() {
		return state;
	}
	
    /**
     * 设置菜单状态
     * 
     * @param state
     *            菜单状态
     */
	public void setState(String state) {
		this.state = state;
	}
	
    /**
     * 获取菜单顺序
     * 
     * @return 菜单顺序
     */
	public long getMenueOrder() {
		return menueOrder;
	}
	
    /**
     * 设置菜单顺序
     * 
     * @param menueOrder
     *            菜单顺序
     */
	public void setMenueOrder(long menueOrder) {
		this.menueOrder = menueOrder;
	}
	
    /**
     * 获取菜单操作者id
     * 
     * @return 菜单操作者id
     */
	public long getStaffId() {
		return staffId;
	}
	
    /**
     * 设置菜单操作者id
     * 
     * @param staffId
     *            菜单操作者id
     */
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	
    /**
     * 获取菜单变更时间
     * 
     * @return 菜单变更时间
     */
	public Date getStateUpdtTime() {
		return stateUpdtTime;
	}
	
    /**
     * 设置菜单变更时间
     * 
     * @param stateUpdtTime
     *            菜单变更时间
     */
	public void setStateUpdtTime(Date stateUpdtTime) {
		this.stateUpdtTime = stateUpdtTime;
	}
	
    /**
     * 获取菜单子菜单
     * 
     * @return 菜单子菜单
     */
	public List<Menue> getChildrenMenueList() {
		return childrenMenueList;
	}
	
    /**
     * 设置菜单子菜单
     * 
     * @param childrenMenueList
     *            菜单子菜单
     */
	public void setChildrenMenueList(List<Menue> childrenMenueList) {
		this.childrenMenueList = childrenMenueList;
	}
	
    /**
     * 获取菜单url
     * 
     * @return 菜单url
     */
	public String getMenueUrl() {
		return menueUrl;
	}
	
    /**
     * 设置菜单url
     * 
     * @param menueUrl
     *            菜单url
     */
	public void setMenueUrl(String menueUrl) {
		this.menueUrl = menueUrl;
	}
}
