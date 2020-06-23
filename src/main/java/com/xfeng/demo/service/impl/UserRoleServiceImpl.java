package com.xfeng.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xfeng.demo.mapper.UserRoleMapper;
import com.xfeng.demo.model.entity.UserRole;
import com.xfeng.demo.service.UserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    private final UserRoleMapper userRoleMapper;


    @Override
    public Set<Long> selectRoleIdsByUserId(Long userId) {
        return userRoleMapper.selectRoleIdByUserId(userId);
    }

    @Override
    public List<UserRole> savBatch(List<UserRole> userRoles) {
        super.saveBatch(userRoles);
        return userRoles;
    }

    @Override
    public Integer deleteByUserId(Long userId) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getUserId, userId);
        return userRoleMapper.delete(queryWrapper);
    }
}
