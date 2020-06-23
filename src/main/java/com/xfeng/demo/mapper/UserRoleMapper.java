package com.xfeng.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfeng.demo.model.entity.UserRole;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 查询角色Id
     *
     * @param userId userId
     * @return
     */
    @Select("select role_id from user_role where user_id = #{userId}")
    Set<Long> selectRoleIdByUserId(Long userId);
}
