package com.xfeng.demo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 2271047798777579921L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 上级Id
     */
    private Long parentId;

    /**
     * 权限code
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;
}
