package com.xfeng.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.xfeng.demo.model.entity.base.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Data
public class Role extends BaseEntity {
    private static final long serialVersionUID = 2894084696957446855L;

    /**
     * 编码
     */
    @NotBlank
    @Size(max = 30, message = "编码长度不能超过30个字符")
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 30, message = "名称长度不能超过30个字符")
    private String name;

    /**
     * 权限id集合
     */
    @TableField(exist = false)
    private Set<Long> permissionIds;
}
