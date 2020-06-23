package com.xfeng.demo.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = 4524793436803772482L;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 角色Id
     */
    private Long roleId;
}
