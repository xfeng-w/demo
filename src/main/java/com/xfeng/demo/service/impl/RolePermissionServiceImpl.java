package com.xfeng.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xfeng.demo.mapper.RolePermissionMapper;
import com.xfeng.demo.model.entity.RolePermission;
import com.xfeng.demo.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    @Override
    public Set<Long> selectByRoleIds(Set<Long> roleIds) {
        return rolePermissionMapper.selectByRoleIds(roleIds);
    }

    @Override
    public List<RolePermission> saveBatch(List<RolePermission> rolePermissions) {
        super.saveBatch(rolePermissions);
        return rolePermissions;
    }

    @Override
    public Integer deleteByRoleId(Long roleId) {
        LambdaQueryWrapper<RolePermission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RolePermission::getRoleId, roleId);
        return rolePermissionMapper.delete(queryWrapper);
    }
}
