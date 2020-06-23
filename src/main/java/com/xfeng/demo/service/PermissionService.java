package com.xfeng.demo.service;

import com.xfeng.demo.model.entity.Permission;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface PermissionService {

    /**
     * 查询权限
     *
     * @param ids roleIds
     * @return
     */
    Set<String> selectByIds(Set<Long> ids);

    /**
     * 新增权限
     *
     * @param permission
     * @return
     */
    Permission insert(Permission permission);

    /**
     * 修改权限
     *
     * @param permission
     * @return
     */
    Permission update(Permission permission);
}
