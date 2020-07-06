package com.xfeng.demo.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.DialectModel;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.IDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Date:Create：in 2020/7/6 15:40
 * @Author: wjwei
 */
public class BigRecordMySqlDialect implements IDialect {
    private static final Logger LOGGER = LoggerFactory.getLogger(BigRecordMySqlDialect.class);

    @Override
    public DialectModel buildPaginationSql(String originalSql, long offset, long limit) {
        String sql = originalSql + " LIMIT " + FIRST_MARK + StringPool.COMMA + SECOND_MARK;
        if(offset>10000000){
            LOGGER.info("大数据量进入");
        }
        LOGGER.info("进入自定义分页查询");
        return new DialectModel(sql, offset, limit).setConsumerChain();
    }
}
