package com.xfeng.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xfeng.demo.model.dto.AccountDTO;
import com.xfeng.demo.model.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
public interface UserService {

    /**
     * 用户分页查询
     *
     * @param word     模糊查询条件
     * @param pageable 分页参数
     * @return
     */
    IPage<User> page(String word, Pageable pageable);

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
     * 删除Id
     *
     * @param id 用户Id
     * @return
     */
    Integer delete(Long id);

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
