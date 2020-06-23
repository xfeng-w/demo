package com.xfeng.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfeng.demo.model.entity.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 查询权限
     *
     * @param roleIds roleIds
     * @return
     */
    @Select("<script>" +
            "select permission_id from role_permission where role_id in " +
                "<foreach collection='roleIds' item='id' open='(' separator=',' close=')'>" +
                    "#{id}" +
                "</foreach>" +
            "</script>")
    Set<Long> selectByRoleIds(@Param("roleIds") Set<Long> roleIds);
}
