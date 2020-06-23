package com.xfeng.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xfeng.demo.model.entity.Role;
import org.springframework.data.domain.Pageable;


/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
public interface RoleService {

    /**
     * 根据Id查询角色
     *
     * @param id
     * @return
     */
    Role info(Long id);

    /**
     * 分页查询
     *
     * @param word     模糊查询参数
     * @param pageable 分页参数
     * @return
     */
    IPage<Role> page(String word, Pageable pageable);

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    Role insert(Role role);

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    Role edit(Role role);

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    Integer delete(Long id);
}
