package com.xfeng.demo.config;

import com.louislivi.fastdep.shirojwt.shiro.FastDepShiroJwtAuthorization;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.service.UserService;
import com.xfeng.demo.util.JacksonUtils;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-06-22
 */
@Configuration
@RequiredArgsConstructor
public class FastDepShiroJwtConfig extends FastDepShiroJwtAuthorization {

    private final UserService userService;

    @Override
    public SimpleAuthorizationInfo getAuthorizationInfo(String user) {
        UserDTO userDTO = JacksonUtils.readJson2Entity(user, UserDTO.class);
        // 查询该用户下的所有权限
        Set<String> collect = userService.selectPermissions(userDTO.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 添加用户权限到SimpleAuthorizationInfo中
        simpleAuthorizationInfo.addStringPermissions(collect);
        return simpleAuthorizationInfo;
    }

}
