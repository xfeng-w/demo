package com.xfeng.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfeng.demo.model.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户Id查询角色
     *
     * @param userId userId
     * @return
     */
    @Select("select id from user_role where user_id = #{userId}")
    Set<Long> selectByUserId(Long userId);
}
