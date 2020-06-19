package com.xfeng.demo.config.authz;

import java.lang.annotation.*;

/**
 * @author xuefeng.wang
 * @date 2020-06-01
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    String value() default "user";
}
