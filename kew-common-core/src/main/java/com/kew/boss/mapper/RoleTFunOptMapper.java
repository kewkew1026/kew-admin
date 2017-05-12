package com.kew.boss.mapper;

import com.kew.boss.model.RoleTFunOpt;


public interface RoleTFunOptMapper
{
    /**
     * 添加
     * @param entity
     */
     void add(RoleTFunOpt entity);
    
    /**
     * 删除
     * @param entity
     */
     void del(Long roleid);
    
    /**
     * 判断当前资源下有角色
     * @param funOptId 资源ID
     * @return
     */
     boolean isNull(Integer funOptId);
    
    /**
     * 根据资源查询所有的数据
     * @param funOptId 资源ID
     * @return
     */
     java.util.List<RoleTFunOpt> findByFunOptId(Integer funOptId);
}
