package com.xfeng.demo.service;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface UserRoleService {

    /**
     * 查询角色Id
     *
     * @param userId userId
     * @return
     */
    Set<Long> selectRoleIdsByUserId(Long userId);
}
