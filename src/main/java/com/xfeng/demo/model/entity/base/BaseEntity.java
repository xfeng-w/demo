package com.xfeng.demo.model.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.xfeng.demo.jsonview.View;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 3845385812619841964L;

    /**
     * 主键
     */
    @Null
    @NotNull
    @TableId(type = IdType.AUTO)
    @JsonView(View.SelectionsView.class)
    private Long id;

    /**
     * 创建者id
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * 更新者id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    /**
     * 版本
     */
    @TableField(fill = FieldFill.INSERT)
    @Version
    @NotNull
    @JsonView(View.ApiView.class)
    private Integer version;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;
}
