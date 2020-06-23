package com.xfeng.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfeng.demo.model.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询权限
     *
     * @param ids roleIds
     * @return
     */
    @Select("<script>" +
            "select code from permission where id in" +
                "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
                    "#{id}" +
                "</foreach>" +
            "</script>")
    Set<String> selectByIds(@Param("ids") Set<Long> ids);
}
