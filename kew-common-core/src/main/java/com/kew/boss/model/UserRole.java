package com.kew.boss.model;

import java.io.Serializable;

public class UserRole implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -7551656658989082786L;
    /**
	 * 角色id
	 */
	private Integer roleId;
	/**
	 * 用户id
	 */
	private long userId;

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
