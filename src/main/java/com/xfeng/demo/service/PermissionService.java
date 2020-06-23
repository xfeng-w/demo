package com.xfeng.demo.service;

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
}
