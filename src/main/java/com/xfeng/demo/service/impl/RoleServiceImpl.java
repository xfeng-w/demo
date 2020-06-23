package com.xfeng.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xfeng.demo.mapper.RoleMapper;
import com.xfeng.demo.model.entity.Role;
import com.xfeng.demo.model.entity.RolePermission;
import com.xfeng.demo.service.RolePermissionService;
import com.xfeng.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    private final RolePermissionService rolePermissionService;

    @Override
    public Role info(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public IPage<Role> page(String word, Pageable pageable) {
        Page<Role> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(word)) {
            queryWrapper.like(Role::getName, word);
        }
        return roleMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Role insert(Role role) {
        roleMapper.insert(role);
        this.saveRolePermission(role.getId(), role.getPermissionIds());
        return role;
    }

    @Override
    public Role edit(Role role) {
        Role saveEntity = this.info(role.getId());
        if (Objects.nonNull(saveEntity)) {
            saveEntity.setCode(role.getCode());
            saveEntity.setName(role.getName());
            roleMapper.updateById(saveEntity);
            rolePermissionService.deleteByRoleId(role.getId());
            this.saveRolePermission(role.getId(), role.getPermissionIds());
            return saveEntity;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long id) {
        rolePermissionService.deleteByRoleId(id);
        return roleMapper.deleteById(id);
    }

    /**
     * 保存角色权限
     *
     * @param roleId        角色id
     * @param permissionIds 权限id集合
     */
    private void saveRolePermission(Long roleId, Set<Long> permissionIds) {
        if (CollectionUtils.isNotEmpty(permissionIds)) {
            List<RolePermission> rolePermissions = new ArrayList<>(permissionIds.size());
            permissionIds.forEach(i -> {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(roleId);
                rolePermission.setPermissionId(i);
                rolePermissions.add(rolePermission);
            });
            rolePermissionService.saveBatch(rolePermissions);
        }
    }

}
