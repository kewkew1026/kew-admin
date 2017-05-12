package com.kew.boss.model;

import java.io.Serializable;

public class RoleTFunOpt implements Serializable
{
    private static final long serialVersionUID = -1051923456166600083L;

    private Integer              roleid;                 /**角色ID**/
    
    private Integer              funOptId;               /**资源ID**/   

    public Integer getFunOptId()
    {
        return funOptId;
    }

    public void setFunOptId(Integer funOptId)
    {
        this.funOptId = funOptId;
    }

    public Integer getRoleid()
    {
        return roleid;
    }

    public void setRoleid(Integer roleid)
    {
        this.roleid = roleid;
    }
}
