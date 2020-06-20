package com.xfeng.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
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
        Date date = new Date();
        this.setFieldValByName(CREATED_TIME, date, metaObject);
        this.setFieldValByName(UPDATED_TIME, date, metaObject);
        this.setFieldValByName(VERSION, 1, metaObject);
        this.setFieldValByName(DELETED, false, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date date = new Date();
        this.setFieldValByName(UPDATED_TIME, date, metaObject);
    }
}
