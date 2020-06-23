package com.xfeng.demo.service.impl;

import com.xfeng.demo.mapper.RolePermissionMapper;
import com.xfeng.demo.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    @Override
    public Set<Long> selectByRoleIds(Set<Long> roleIds) {
        return rolePermissionMapper.selectByRoleIds(roleIds);
    }
}
