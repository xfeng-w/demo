package com.xfeng.demo.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author xuefeng.wang
 * @date 2020-06-20
 */
@Data
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = -8711622730937475897L;

    /**
     * 账号
     */
    @NotBlank(message = "请输入登陆账号")
    private String account;

    /**
     * 密码
     */
    @NotBlank(message = "请输入登陆密码")
    private String password;
}
