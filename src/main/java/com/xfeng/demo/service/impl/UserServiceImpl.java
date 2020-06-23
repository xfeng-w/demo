package com.xfeng.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xfeng.demo.mapper.UserMapper;
import com.xfeng.demo.model.dto.AccountDTO;
import com.xfeng.demo.model.entity.User;
import com.xfeng.demo.model.entity.UserRole;
import com.xfeng.demo.service.PermissionService;
import com.xfeng.demo.service.RolePermissionService;
import com.xfeng.demo.service.UserRoleService;
import com.xfeng.demo.service.UserService;
import com.xfeng.demo.util.Md5SaltUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserMapper userMapper;

    private final UserRoleService userRoleService;

    private final RolePermissionService rolePermissionService;

    private final PermissionService permissionService;

    @Override
    public IPage<User> page(String word, Pageable pageable) {
        Page<User> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(word)) {
            queryWrapper.like(User::getAccount, word);
        }
        return userMapper.selectPage(page, queryWrapper);
    }

    @Override
    public User info(Long id) {
        User user = userMapper.selectById(id);
        if (Objects.nonNull(user)) {
            Set<Long> roleIds = userRoleService.selectRoleIdsByUserId(id);
            user.setRoleIds(roleIds);
        }
        return user;
    }

    @Override
    public User insertUser(User user) {
        User saveEntity = new User();
        saveEntity.setName(user.getName());
        saveEntity.setAccount(user.getAccount());
        String salt = Md5SaltUtils.getSalt(16);
        saveEntity.setSalt(salt);
        saveEntity.setPassword(Md5SaltUtils.generateBySalt(user.getPassword(), salt));
        userMapper.insert(saveEntity);
        if (CollectionUtils.isNotEmpty(user.getRoleIds())) {
            this.saveRoles(saveEntity.getId(),user.getRoleIds());
        }
        return saveEntity;
    }

    @Override
    public User editUser(User user) {
        User saveEntity = userMapper.selectById(user.getId());
        if (Objects.isNull(saveEntity)) {
            return null;
        }
        saveEntity.setAccount(user.getAccount());
        saveEntity.setName(user.getName());
        saveEntity.setPassword(Md5SaltUtils.generateBySalt(user.getPassword(), saveEntity.getSalt()));
        userMapper.updateById(saveEntity);
        if (CollectionUtils.isNotEmpty(user.getRoleIds())) {
            userRoleService.deleteByUserId(user.getId());
            this.saveRoles(saveEntity.getId(),user.getRoleIds());
        }
        return saveEntity;
    }

    @Override
    public Integer delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User selectByAccount(AccountDTO account) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAccount, account.getAccount());
        User user = userMapper.selectOne(wrapper);
        if (Objects.nonNull(user) && user.getPassword().equals(Md5SaltUtils.generateBySalt(account.getPassword(), user.getSalt()))) {
            return user;
        }
        return null;
    }

    @Override
    public Set<String> selectPermissions(Long userId) {
        User user = this.info(userId);
        if (Objects.nonNull(user) && CollectionUtils.isNotEmpty(user.getRoleIds())) {
            Set<Long> permissionIds = rolePermissionService.selectByRoleIds(user.getRoleIds());
            if (CollectionUtils.isNotEmpty(permissionIds)) {
                return permissionService.selectByIds(permissionIds);
            }
        }
        return null;
    }

    /**
     * 保存用户角色信息
     *
     * @param userId  用户Id
     * @param roleIds 角色Id集合
     */
    private void saveRoles(Long userId, Set<Long> roleIds) {
        List<UserRole> userRoles = new ArrayList<>();
        roleIds.forEach(item -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(item);
            userRoles.add(userRole);
        });
        userRoleService.savBatch(userRoles);
    }
}
