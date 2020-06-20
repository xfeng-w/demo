package com.xfeng.demo.enums;

import lombok.Getter;

/**
 * @author xuefeng.wang
 * @date 2020-06-20
 */
@Getter
public enum ResultCode {
    SUCCESS(1000, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");

    private Integer code;

    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
