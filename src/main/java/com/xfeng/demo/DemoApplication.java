package com.xfeng.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 *
 * @author xuefeng.wang
 * @date 2020-05-21
 */
@MapperScan("com.xfeng.demo.mapper")
@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

    // 123
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
