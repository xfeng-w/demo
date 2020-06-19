package com.xfeng.demo.service.impl;

import com.xfeng.demo.mapper.UserMapper;
import com.xfeng.demo.model.entity.User;
import com.xfeng.demo.service.UserService;
import com.xfeng.demo.util.JacksonUtils;
import com.xfeng.demo.util.Md5SaltUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserMapper userMapper;

    @Override
    public User insertUser(User user) {
        User saveEntity = new User();
        saveEntity.setName(user.getName());
        saveEntity.setAccount(user.getAccount());
        String salt = Md5SaltUtil.getSalt(16);
        saveEntity.setSalt(salt);
        saveEntity.setPassword(Md5SaltUtil.generateBySalt(user.getPassword(), salt));
        userMapper.insert(saveEntity);
        logger.info("新增用户：{}", JacksonUtils.write2JsonString(saveEntity));
        return saveEntity;
    }

    @Override
    public User editUser(User user) {
        User saveEntity = userMapper.selectById(user.getId());
        if (Objects.isNull(saveEntity)) {
            return null;
        }
        saveEntity.setAccount(user.getAccount());
        saveEntity.setName(user.getName());
        saveEntity.setPassword(Md5SaltUtil.generateBySalt(user.getPassword(), saveEntity.getSalt()));
        userMapper.updateById(saveEntity);
        logger.info("修改用户：{}", JacksonUtils.write2JsonString(saveEntity));
        return saveEntity;
    }
}
