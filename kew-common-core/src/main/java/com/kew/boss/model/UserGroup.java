package com.kew.boss.model;

import java.io.Serializable;

public class UserGroup implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private long groupId;  //用户组ID
    private String groupName;  //用户组名称
	//private long updateCount;  //更新次数
	//private Date lastUpdateTime ;  //最近更新时间
	//private long UpdateUserId;     //更新人
	//private Date createTime;       //创建时间
	//private long createUserId;     //创建人
	
	public UserGroup(){
		super();
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
