package com.xfeng.demo.service;

import com.xfeng.demo.model.dto.AccountDTO;
import com.xfeng.demo.model.entity.User;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
public interface UserService {

    /**
     * 根据Id查询
     *
     * @param id 用户Id
     * @return
     */
    User info(Long id);

    /**
     * 新增用户
     *
     * @param user User
     * @return User
     */
    User insertUser(User user);

    /**
     * 修改用户
     *
     * @param user User
     * @return User
     */
    User editUser(User user);

    /**
     * 根据帐号查询
     *
     * @param account 帐号信息
     * @return
     */
    User selectByAccount(AccountDTO account);

    /**
     * 查询权限
     *
     * @param userId userId
     * @return
     */
    Set<String> selectPermissions(Long userId);

}
