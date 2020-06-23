package com.xfeng.demo.service.impl;

import com.xfeng.demo.mapper.UserRoleMapper;
import com.xfeng.demo.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleMapper userRoleMapper;


    @Override
    public Set<Long> selectRoleIdsByUserId(Long userId) {
        return userRoleMapper.selectRoleIdByUserId(userId);
    }
}
