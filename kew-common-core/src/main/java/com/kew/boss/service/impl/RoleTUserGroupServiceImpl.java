package com.kew.boss.service.impl;

import com.kew.boss.service.RoleTUserGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleTUserGroupServiceImpl implements RoleTUserGroupService
{
//    @Autowired
//    private RoleTUserGroupMapper roleTUserGroupMapper;
//    
//      public void add(RoleTUserGroup entity)
//    {
//          roleTUserGroupMapper.add(entity);
//    }
//
//    public void del(Integer roleId)
//    {
//         roleTUserGroupMapper.del(roleId);
//    }
//
//    @Transactional(readOnly=true)
//    public void delFindByRoleTUserGroup(String roleid, String groupid)
//    {
//        if(roleid!=null&&groupid!=null)
//        {
//            if(groupid.length()>0)
//            {
//                /**删除角色的功能用户组**/
//                del(Integer.parseInt(roleid));
//                 
//                String[] funArray = groupid.split(",");
//                 
//                for (int i = 0; i < funArray.length; i++)
//                {
//                    RoleTUserGroup entity = new RoleTUserGroup();
//                    entity.setRoleId(Integer.parseInt(roleid));
//                    entity.setGroupId(Integer.parseInt(funArray[i]));
//                    add(entity);
//                }
//            }else
//            {
//                /**删除角色所有用户组**/
//                del(Integer.parseInt(roleid));
//            }
//        }
//    }
      
    
}
