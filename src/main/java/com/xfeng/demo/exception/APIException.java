package com.xfeng.demo.exception;

import lombok.Data;

/**
 * @author xuefeng.wang
 * @date 2020-06-20
 */
@Data
public class APIException extends RuntimeException {
    private static final long serialVersionUID = -1461411533370468470L;

    private int code;

    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
