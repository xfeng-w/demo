package com.xfeng.demo.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 2271047798777579921L;

    private Long id;

    private Long parentId;

    private String code;

    private String name;
}
