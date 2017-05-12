
package com.kew.boss.service.impl;

import com.kew.page.Page;
import com.kew.boss.mapper.*;
import com.kew.boss.model.*;
import com.kew.boss.service.RbacService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RbacServiceImpl implements RbacService{
	
	private static String VALID_CODE = "1";
	private static String INVALID_CODE = "0";
	
	private static String VALID = "有效";
	private static String INVALID = "无效";
	
	/**
	 * 用户Mapper
	 */
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 用户信息Mapper
	 */
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/**
	 * 用户组Mapper
	 */
	@Autowired
	private UserGroupMapper userGroupMapper ;
	
	/**
	 * 角色Mapper
	 */
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 用户认证Mapper
	 */
	@Autowired
	private UserRbacMapper userRbacMapper;
	
//	@Autowired
//	private PosiService posiService;
//	
//	@Autowired
//	private DeptService deptService;
	
	
    
    /**
     * 根据loginid获取用户信息
     * 
     * @param id
     *            用户登录id
     * @return 用户信息
     */
	@Transactional(readOnly = true)
	public User getUserById(long id) {
		return userMapper.getUserById(id);
	}
	/**
	 * 新增用户
	 * @param user 用户
	 */
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
	
	/**
	 * 通过用户名获得用户
	 * @param name 用户名称
	 * @return 用户
	 */
	@Transactional(readOnly = true)
	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}
	
	/**
	 * 更新用户
	 * @param user 用户
	 */
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	/**
	 * 删除用户
	 * @param id 用户id
	 */
	public void deleteUser(long id) {
		
		userRbacMapper.delUserGrpByUserId(id);  //删除用户用户组关联
		userRbacMapper.delUserRoleByUserId(id); //删除用户角色关联
		userInfoMapper.deleteUserInfo(id);      //删除用户属性信息
		//userMapper.deleteUser(id);              //删除用户记录
	}
	
	/**
	 * 后台操作员增加
	 * @param user 用户基本信息
	 * @param userInfo 用户属性信息
	 */
	public void insertUserInfo(User user,UserInfo userInfo) {
		user.setPwd(DigestUtils.md5Hex(user.getPwd()));
        userMapper.insertUser(user);
        userInfo.setUserId(user.getUserId());
        userInfoMapper.insertUserInfo(userInfo);
	}
	
    /**
     * 更新用户信息
     * @param userInfo 用户属性信息
     */
	public void updateUserInfo(UserInfo userInfo) {
		userInfoMapper.updateUserInfo(userInfo);
	}
	
    /**
	 * 通过用户Id获得用户信息
	 * @param id 用户Id
	 * @return 用户信息
	 */
	@Transactional(readOnly = true)
	public UserInfo getUserInfoById(long id) {
		return userInfoMapper.getUserInfoById(id);
	}
    
    
	/**
	 * 查询所有用户组
	 * @return 用户组list
	 */
	@Transactional(readOnly=true)
	public List<UserGroup> getAllUserGroup() {
		return userGroupMapper.getAllUserGroup();
	}
	
	/**
	 * 通过用户组名称查询用户组信息
	 * @param groupName 户组名称
	 * @return 用户组信息
	 */
	@Transactional(readOnly=true)
	public UserGroup getUserGroupByName(String groupName) {
		return userGroupMapper.getUserGroupByName(groupName);
	}
	
	/**
	 * 通过用户组ID查询用户组信息
	 * @param groupId 用户组ID
	 * @return 用户组信息
	 */
	@Transactional(readOnly=true)
	public UserGroup getUserGroupById(long groupId) {
		return userGroupMapper.getUserGroupById(groupId);
	}
	
	/**
	 * 新增用户组
	 * @param userGroup 用户组
	 */
	public void addUserGroup(UserGroup userGroup) {
		userGroupMapper.addUserGroup(userGroup);
	}
	
	/**
	 * 更新用户组信息
	 * @param userGroup 用户组
	 */
	public void updateUserGroup(UserGroup userGroup) {
		userGroupMapper.updateUserGroup(userGroup);
	}
	
	/**
	 * 删除用户组
	 * @param groupId 用户组id
	 */
	public void deleteUserGroup(long groupId) {
		userGroupMapper.deleteUserGroup(groupId);
	}
	
	/**
	 * 查询所有角色
	 * @return 角色list
	 */
	@Transactional(readOnly=true)
	public List<Role> getAllRole() {
		return roleMapper.getAllRole();
	}
	
	/**
	 * 通过角色名查询角色
	 * @param roleName 角色名
	 * @return 角色
	 */
	@Transactional(readOnly=true)
	public Role getRoleByName(String roleName) {
		return roleMapper.getRoleByName(roleName);
	}
	
	/**
	 * 通过条件查询角色
	 * @param role 角色
	 * @param rowBounds 分页对象
	 * @return 角色list
	 */
	@Transactional(readOnly=true)
	public List<Role> getRoleByCondition(Role role,RowBounds rowBounds) {
		return roleMapper.getRoleByCondition(role,rowBounds);
	}

	/**
	 * 通过角色Id查找角色
	 * @param roleId 角色id
	 * @return 角色
	 */
	@Transactional(readOnly=true)
	public Role getRoleById(long roleId) {
		return roleMapper.getRoleById(roleId);
	}
	
	/**
	 * 增加角色
	 * @param role 角色
	 */
	public void addRole(Role role) {
		roleMapper.addRole(role);
	}
	
	/**
	 * 更新角色信息
	 * @param role 角色
	 */
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}
	
	/**
	 * 删除角色
	 * 
	 * @param roleId 角色id
	 */
	public void deleteRole(long roleId) {
		roleMapper.deleteRole(roleId);
	}
	
    /**
     * 查询该角色下的分配用户组
     * @param roleId 角色ID
     * @return 用户组list
     */
	@Transactional(readOnly = true)
    public List<UserGroup> findByRoleUserGroup(long roleId)
    {
        return userGroupMapper.findByRoleUserGroup(roleId);
    }
    
    /**
     * 查询该角色下的未配用户组
     * @param roleId 角色ID
     * @return 用户组list
     */
	@Transactional(readOnly = true)
    public List<UserGroup> findByRoleUnUserGroup(long roleId)
    {
        return userGroupMapper.findByRoleUnUserGroup(roleId);
    }
    
    /**
     * 根据用户id获取不属于该用户角色（不包含用户组继承角色）
     * 
     * @param userId
     *            用户id
     * @return 用户没有关联的角色信息list（不包含用户组继承角色）
     */
	@Transactional(readOnly = true)
	public List<Role> getUnRloesNotGrpByUserId(long userId){
		return userRbacMapper.getUnRloesNotGrpByUserId(userId);
	}
	
    /**
     * 根据用户id获取属于该用户角色（不包含用户组继承角色）
     * 
     * @param userId
     *            用户id
     * @return 用户关联的角色信息list（不包含用户组继承角色）
     */
	@Transactional(readOnly = true)
	public List<Role> getRloesNotGrpByUserId(long userId){
		return userRbacMapper.getRloesNotGrpByUserId(userId);
	}
	
    /**
     * 根据用户id获取属于该用户的用户组
     * 
     * @param userId
     *            用户id
     * @return 该用户的用户组list
     */
	@Transactional(readOnly = true)
	public List<UserGroup> getUserGroupByUserId(long userId){
		return userRbacMapper.getUserGroupByUserId(userId);
	}
	
    /**
     * 根据用户id获取不属于该用户组
     * 
     * @param userId
     *            用户id
     * @return 不属于该用户的用户组list
     */
	@Transactional(readOnly = true)
	public List<UserGroup> getUnUserGroupByUserId(long userId){
		return userRbacMapper.getUnUserGroupByUserId(userId);
	}
	
	/**
	 * 增加用户所属的用户组
	 * @param userId 用户组id
	 * @param userGrpIds 用户组id串
	 */
	public void editUserGroupUser(long userId,String[] userGrpIds){
		// 删除用户所属的用户组
		userRbacMapper.delUserGrpByUserId(userId);
		if(userGrpIds != null && !"".equals(userGrpIds)){
			//String[] userGrpIdArray = userGrpIds.split(",");
			UserGroupUser userGroupUser = new UserGroupUser();
			userGroupUser.setUserId(userId);
			for(String userGrpId :userGrpIds){
				userGroupUser.setGrpId(Long.parseLong(userGrpId));
				userRbacMapper.instUserGroupUser(userGroupUser);
			}
		}
	}
	
	/**
	 * 增加用户所属的角色
	 * @param userId 用户组id
	 * @param roleIds 角色id串
	 */
	public void editUserRole(long userId,String[] roleIds){
		// 删除用户所属的角色
		userRbacMapper.delUserRoleByUserId(userId);
		if(roleIds != null && !"".equals(roleIds)){
			//String[] roleIdArray = roleIds.split(",");
			UserRole userRole = new UserRole();
			userRole.setUserId(userId);
			for(String roleId :roleIds){
				userRole.setRoleId(Integer.parseInt(roleId));
				userRbacMapper.instUserRole(userRole);
			}
		}
	}
	
	/**
	 * 是否可以删除用户组
	 * @param userGrpId 用户组id
	 * @return true：可删除 false：不可删除
	 */
	@Transactional(readOnly = true)
	public boolean isEnableDelUserGrp(long userGrpId) {
		if(userGroupMapper.isEnableDelUserGrp(userGrpId)>0){
			return false ;
		}
		return true;
	}
	
	/**
	 * 是否可以删除角色
	 * @param roleId 角色id
	 * @return true：可删除 false：不可删除
	 */
	@Transactional(readOnly = true)
	public boolean isEnableDelRole(long roleId) {
		if(roleMapper.isEnableDelRole(roleId)>0){
			return false;
		}
		return true;
	}
	
	@Transactional(readOnly = true)
	public List<UserGroup> getUserGroupByCondition(UserGroup userGroup,
			RowBounds rowBounds) {
		return userGroupMapper.getUserGroupByCondition(userGroup,rowBounds);
	}
	
	/**
	 * 按条件查询用户组总数
	 * @param userGroup
	 * @return
	 */
	@Transactional(readOnly = true)
	public int getUserGroupTotal(UserGroup userGroup) {
		return userGroupMapper.getUserGroupTotal(userGroup);
	}
	
	/**
	 * 按条件查询用户总数
	 * @param userInfo
	 * @return
	 */
	@Transactional(readOnly = true)
	public int getUserTotal(UserInfo userInfo) {
		return userInfoMapper.getUserTotal(userInfo);
	}
	
	/**
	 * 通过条件查询用户组信息
	 * @param userInfo 用户组名称
	 * @param rowBounds 分页对象
	 * @return 用户组信息
	 */
	@Transactional(readOnly = true)
	public List<UserInfo> getUserInfoByCondition(UserInfo userInfo,
			RowBounds rowBounds) {
		return userInfoMapper.getUserInfoByCondition(userInfo,rowBounds);
	}
	
	/**
	 * 通过条件查询角色总数
	 * @param role 角色
	 * @return 角色总数
	 */
	@Transactional(readOnly = true)
	public int getRoleTotal(Role role) {
		return roleMapper.getRoleTotal(role);
	}
	
	/**
	 * 更改用户密码
	 * @param userId 用户id
	 * @param pwd 用户密码
	 */
	public void updateUserPassword(long userId,String pwd) {
		User user = new User();
		user.setUserId(userId);
		user.setPwd(pwd);
		
		userMapper.updateUserPassword(user);
	}
	
	/**
	 * 根据用户名密码获得用户
	 * @param username
	 * @param password
	 * @return
	 */
	@Transactional(readOnly = true)
	public User authUser(String username, String password) {
		return userMapper.getUserByNameAndPwd(username, password);
	}
	
	/**
	 * 按条件查询获得分页对象
	 * @param userInfo
	 * @param rowBounds
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<UserInfo> getPageModel(UserInfo userInfo, RowBounds rowBounds) {
		int total = userInfoMapper.getUserTotal(userInfo);
		List<UserInfo> list = userInfoMapper.getUserInfoByCondition(userInfo,rowBounds);
		for(int i=0;i<list.size();i++){
			UserInfo myUserInfo = list.get(i);
			String userStatus = myUserInfo.getUserStatus();
			if(VALID_CODE.equals(userStatus)){
				myUserInfo.setUserStatus(VALID);
			}
			
			if(INVALID_CODE.equals(userStatus)){
				myUserInfo.setUserStatus(INVALID);
			}
			
//			List<Posi> posiList = posiService.data();
//			List<Dept> deptList = deptService.data();
			
			Long posiId = myUserInfo.getUserPosiId();
			Long deptId = myUserInfo.getUserDepartId();
			
//			for(int j=0;j<posiList.size();j++){
//				
//				if(posiId!=null && (long)posiList.get(j).getPosiId()==posiId){
//					myUserInfo.setUserPosiName(posiList.get(j).getPosiName());
//				}
//				
//				if(deptId!=null && deptList.get(j).getDepartId()==deptId){
//					myUserInfo.setUserDepartName(posiList.get(j).getPosiName());
//				}
//			}
		}
		Page<UserInfo> info = new Page<UserInfo>(total,list);
		return info;
	}
	
	/**
	 * 按条件查询获得分页对象
	 * @param role
	 * @param rowBounds
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Role> getPageModel(Role role, RowBounds rowBounds) {
		int total = roleMapper.getRoleTotal(role);
		List<Role> list = roleMapper.getRoleByCondition(role, rowBounds);
		Page<Role> myrole = new Page<Role>(total,list);
		return myrole;
	}
	
	/**
	 * 按条件查询获得分页对象
	 * @param userGroup
	 * @param rowBounds
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<UserGroup> getPageModel(UserGroup userGroup, RowBounds rowBounds) {
		int total = userGroupMapper.getUserGroupTotal(userGroup);
		List<UserGroup> list = userGroupMapper.getUserGroupByCondition(userGroup, rowBounds);
		Page<UserGroup> myGroup = new Page<UserGroup>(total,list);
		return myGroup;
	}
	
	/**
	 * 更新角色下的用户组
	 * @param roleid
	 * @param groupid
	 */
	public void delFindByRoleTUserGroup(String roleid, String[] groupid)
    {
        if(roleid!=null&&groupid!=null)
        {
            if(groupid.length>0)
            {
                /**删除角色的功能用户组**/
                del(Integer.parseInt(roleid));
                 
                //String[] funArray = groupid.split(",");
                 
                for (int i = 0; i < groupid.length; i++)
                {
                    RoleTUserGroup entity = new RoleTUserGroup();
                    entity.setRoleId(Integer.parseInt(roleid));
                    entity.setGroupId(Integer.parseInt(groupid[i]));
                    add(entity);
                }
            }else
            {
                /**删除角色所有用户组**/
                del(Integer.parseInt(roleid));
            }
        }else if(groupid==null){
        	/**删除角色所有用户组**/
            del(Integer.parseInt(roleid));
        }
    }
	
	private void add(RoleTUserGroup entity){
        roleMapper.add(entity);
  }

	private void del(Integer roleId){
		roleMapper.del(roleId);
	}
	
	@Override
	public List<Role> getRloesByUserId(Long userId) {
		return userRbacMapper.getRloesByUserId(userId);
	}
}
