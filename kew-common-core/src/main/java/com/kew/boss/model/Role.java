package com.kew.boss.model;


public class Role implements java.io.Serializable {
	
    /**
	 * 自动生成序列号
	 */
	private static final long serialVersionUID = -7345217450117947809L;
	
    /**
	 * 角色id
	 */
	private Integer roleId;
	
    /**
	 * 角色名称
	 */
	private String roleNm;
	
	/**
	 * 所属组名以，号隔开
	 */
	private String grpNm;

	public String getGrpNm() {
		return grpNm;
	}

	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleNm() {
		return roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}
}