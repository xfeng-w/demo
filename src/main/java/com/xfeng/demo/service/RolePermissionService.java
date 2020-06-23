package com.xfeng.demo.service;

import com.xfeng.demo.model.entity.RolePermission;

import java.util.List;
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

    /**
     * 批量保存
     * @param rolePermissions
     * @return
     */
    List<RolePermission> saveBatch(List<RolePermission> rolePermissions);

    /**
     * 根据user_id删除
     *
     * @param roleId
     * @return
     */
    Integer deleteByRoleId(Long roleId);
}
