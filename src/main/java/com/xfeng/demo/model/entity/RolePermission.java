package com.xfeng.demo.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Data
public class RolePermission implements Serializable {
    private static final long serialVersionUID = -7352883338401576513L;

    /**
     * 角色Id
     */
    private Long roleId;

    /**
     * 权限Id
     */
    private Long permissionId;
}
