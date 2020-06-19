package com.xfeng.demo.service;

import com.xfeng.demo.model.entity.User;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
public interface UserService {

    /**
     * 新增用户
     * @param user User
     * @return User
     */
    User insertUser(User user);

    /**
     * 修改用户
     * @param user User
     * @return User
     */
    User editUser(User user);
}
