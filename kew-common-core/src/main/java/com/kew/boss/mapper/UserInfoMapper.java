package com.kew.boss.mapper;

import com.kew.boss.model.UserInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserInfoMapper {
	
	/**
	 * 通过id得到用户信息
	 * @param id
	 * @return
	 */
	 UserInfo getUserInfoById(long id);
	
	/**
     * 更新用户信息
     * @param userInfo
     */
     void updateUserInfo(UserInfo userInfo);
    
	/**
	 * 后台操作员增加
	 */
     void insertUserInfo(UserInfo userInfo);
    
    /**
     * 通过指定查询条件查询用户信息
     * @param userName
     * @param rowBounds
     * @return
     */
    public List<UserInfo> getUserInfoByCondition(UserInfo userInfo, RowBounds rowBounds);
    
    /**
     * 查询所有的用户信息
     * @return
     */
     List<UserInfo> getAllUser();
    
    
    /**
     * 删除用户信息
     * @param id
     */
     void deleteUserInfo(long id);

    /**
     * 通过指定查询条件查询用户信息总数
     * @param userInfo
     * @return
     */
	 int getUserTotal(UserInfo userInfo);
    
}
