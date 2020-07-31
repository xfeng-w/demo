package com.xfeng.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xfeng.demo.mapper.UserMapper;
import com.xfeng.demo.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xuefeng.wang
 * @date 2020-07-23
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionalTestService {

    private final UserMapper userMapper;

    public List<User> test1() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, 5L);
        wrapper.last(" for update");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.selectList(wrapper);
    }

    public void test2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, 5);
        User user = new User();
        user.setAccount("123");
        user.setName("name1");
        user.setPassword("123");
        userMapper.update(user, wrapper);
    }
}
