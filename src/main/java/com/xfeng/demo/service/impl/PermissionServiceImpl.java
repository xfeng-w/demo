package com.xfeng.demo.service.impl;

import com.xfeng.demo.mapper.PermissionMapper;
import com.xfeng.demo.model.entity.Permission;
import com.xfeng.demo.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;

    @Override
    public Set<String> selectByIds(Set<Long> ids) {
        return permissionMapper.selectByIds(ids);
    }

    @Override
    public Permission insert(Permission permission) {
        permissionMapper.insert(permission);
        return permission;
    }

    @Override
    public Permission update(Permission permission) {
        Permission saveEntity = permissionMapper.selectById(permission.getId());
        if (Objects.nonNull(saveEntity)) {
            saveEntity.setName(permission.getName());
            permissionMapper.updateById(saveEntity);
        }
        return null;
    }
}
