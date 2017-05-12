package com.kew.boss.mapper;

import com.kew.boss.model.User;
import com.kew.boss.model.UserInfo;

/**
 * Created by qiudanping on 2017/5/10.
 */
public interface UserMapper {

    /**
     * 通过用户Id获得用户
     * @param id
     * @return
     */
     User getUserById(long id);

    /**
     * 通过用户名获得用户
     * @param name
     * @return
     */
     User getUserByName(String name);

    /**
     * 新增用户
     * @param user
     */
     void insertUser(User user);

    /**
     * 更新用户
     * @param user
     */
     void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
     void deleteUser(long id);

    /**
     * 按条件查询用户总数
     * @param userInfo
     * @return
     */
     int getUserTotal(UserInfo userInfo);

    /**
     * 更改用户密码
     * @param user user
     */
     void updateUserPassword(User user);

    /**
     * 根据用户名密码获得用户
     * @param username
     * @param password
     * @return
     */
     User getUserByNameAndPwd(String username, String password);
}
