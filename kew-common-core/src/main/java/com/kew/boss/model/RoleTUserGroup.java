package com.kew.boss.model;

import java.io.Serializable;

public class RoleTUserGroup implements Serializable
{
    private static final long serialVersionUID = 2499642624304517979L;

    private Integer           groupId;              /**用户组ID**/
    
    private Integer           roleId;               /**角色ID**/
    
    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    public Integer getGroupId()
    {
        return groupId;
    }

    public void setGroupId(Integer groupId)
    {
        this.groupId = groupId;
    }
}
