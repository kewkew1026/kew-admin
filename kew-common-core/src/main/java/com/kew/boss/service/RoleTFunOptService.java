package com.kew.boss.service;

import com.kew.boss.mapper.RoleTFunOptMapper;

public interface RoleTFunOptService extends RoleTFunOptMapper
{
    /**
     * 删除角色下的所有资源
     * @param roleId
     * @param funOptArray
     */
     void delFindByRoleTFunOpt(String roleId, String[] funOptArray);
}
