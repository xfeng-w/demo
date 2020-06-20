package com.xfeng.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonView;
import com.xfeng.demo.jsonview.View;
import com.xfeng.demo.model.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    private static final long serialVersionUID = 8631062901085084905L;

    /**
     * 名称
     */
    @JsonView(View.PageView.class)
    private String name;

    /**
     * 账号
     */
    @JsonView(View.PageView.class)
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 角色id集合
     */
    @TableField(exist = false)
    private Set<Long> roleIds;


}
