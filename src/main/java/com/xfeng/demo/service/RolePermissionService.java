package com.xfeng.demo.service;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface RolePermissionService {

    /**
     * 查询权限Id
     *
     * @param roleIds roleIds
     * @return
     */
    Set<Long> selectByRoleIds(Set<Long> roleIds);
}
