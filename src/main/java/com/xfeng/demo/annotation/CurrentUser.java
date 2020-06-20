package com.xfeng.demo.annotation;

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
