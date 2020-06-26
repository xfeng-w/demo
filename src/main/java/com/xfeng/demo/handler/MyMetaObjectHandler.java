package com.xfeng.demo.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.util.JacksonUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATED_BY = "createdBy";
    private static final String CREATED_TIME = "createdTime";
    private static final String DELETED = "deleted";
    private static final String VERSION = "version";
    private static final String UPDATED_BY = "updatedBy";
    private static final String UPDATED_TIME = "updatedTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        DecodedJWT jwt = JWT.decode(SecurityUtils.getSubject().getPrincipal().toString());
        UserDTO user = JacksonUtils.readJson2Entity(jwt.getSubject(), UserDTO.class);
        if (user != null) {
            this.setFieldValByName(CREATED_BY, user.getId(), metaObject);
            this.setFieldValByName(UPDATED_BY, user.getId(),metaObject);
        }
        Date date = new Date();
        this.setFieldValByName(CREATED_TIME, date, metaObject);
        this.setFieldValByName(UPDATED_TIME, date, metaObject);
        this.setFieldValByName(VERSION, 1, metaObject);
        this.setFieldValByName(DELETED, false, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        DecodedJWT jwt = JWT.decode(SecurityUtils.getSubject().getPrincipal().toString());
        UserDTO user = JacksonUtils.readJson2Entity(jwt.getSubject(), UserDTO.class);
        if (user != null) {
            this.setFieldValByName(CREATED_BY, user.getId(), metaObject);
            this.setFieldValByName(UPDATED_BY, user.getId(),metaObject);
        }
        Date date = new Date();
        this.setFieldValByName(UPDATED_TIME, date, metaObject);
    }
}
