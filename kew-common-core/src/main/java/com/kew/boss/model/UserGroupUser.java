package com.kew.boss.model;

import java.io.Serializable;

public class UserGroupUser implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 4399825017561430875L;
	//用户组ID
    private long grpId;  
	/**
	 * 用户id
	 */
	private long userId;
	public long getGrpId() {
		return grpId;
	}
	public void setGrpId(long grpId) {
		this.grpId = grpId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
