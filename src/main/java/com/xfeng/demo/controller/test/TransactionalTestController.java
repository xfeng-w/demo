package com.xfeng.demo.controller.test;

import com.xfeng.demo.annotation.CurrentUser;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.model.entity.User;
import com.xfeng.demo.service.TransactionalTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuefeng.wang
 * @date 2020-07-23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("test/transactional/v1")
public class TransactionalTestController {

    private final TransactionalTestService transactionalTestService;

    @GetMapping
    public ResponseEntity<List<User>> test1() {
        return new ResponseEntity<>(transactionalTestService.test1(), HttpStatus.OK);
    }

    @GetMapping("test2")
    public ResponseEntity<Void> test2() {
        transactionalTestService.test2();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
