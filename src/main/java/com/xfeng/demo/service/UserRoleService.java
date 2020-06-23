package com.xfeng.demo.service;

import com.xfeng.demo.model.entity.UserRole;

import java.util.List;
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

    /**
     * 批量保存
     *
     * @param userRoles
     * @return
     */
    List<UserRole> savBatch(List<UserRole> userRoles);

    /**
     * 删除用户角色
     *
     * @param userId 用户Id
     * @return
     */
    Integer deleteByUserId(Long userId);


}
