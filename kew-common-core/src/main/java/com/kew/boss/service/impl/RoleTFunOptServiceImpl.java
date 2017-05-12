package com.kew.boss.service.impl;

import com.kew.boss.mapper.RoleTFunOptMapper;
import com.kew.boss.model.RoleTFunOpt;
import com.kew.boss.service.RoleTFunOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleTFunOptServiceImpl implements RoleTFunOptService
{

    @Autowired
    private RoleTFunOptMapper roleTFunOptMapper;
    
    public void add(RoleTFunOpt entity)
    {
        roleTFunOptMapper.add(entity);
    }

    public void del(Long id)
    {
         roleTFunOptMapper.del(id);
    }

    @Transactional(readOnly = true)
    public boolean isNull(Integer funOptId)
    {
        List<RoleTFunOpt> list = findByFunOptId(funOptId);
        
        if(list != null && list.size()>0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    @Transactional(readOnly = true)
    public List<RoleTFunOpt> findByFunOptId(Integer funOptId)
    {
        return roleTFunOptMapper.findByFunOptId(funOptId);
    }

    public void delFindByRoleTFunOpt(String roleId, String[] funOptArray)
    {
        if(roleId!=null&&funOptArray!=null)
        {
            if(funOptArray.length>0)
            {
                /**删除角色的功能**/
                del(Long.valueOf(roleId));
                 
                 
                for (int i = 0; i < funOptArray.length; i++)
                {
                    RoleTFunOpt entity = new RoleTFunOpt();
                    entity.setRoleid(Integer.parseInt(roleId));
                    entity.setFunOptId(Integer.parseInt(funOptArray[i]));
                    add(entity);
                }
            }else
            {
                /**删除角色所有功能**/
            	  del(Long.valueOf(roleId));
            }
        }else if(funOptArray==null){
        	/**删除角色的功能**/
        	 del(Long.valueOf(roleId));
        }
    }
}
