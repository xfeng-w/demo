package com.xfeng.demo.controller.test;

import com.xfeng.demo.annotation.CurrentUser;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuefeng.wang
 * @date 2020-06-03
 */
@Api("Redis测试接口 ")
@RequestMapping("test/redis/v1")
@RestController
@RequiredArgsConstructor
public class RedisTestController {

    private final RedisService redisService;

    @ApiOperation(value = "setKey")
    @GetMapping("set")
    public ResponseEntity<Void> setKey(@CurrentUser UserDTO userDTO, @RequestParam String key, @RequestParam String value) {
        redisService.set(key, value);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "hasKey")
    @GetMapping("hasKey")
    public ResponseEntity<Boolean> hasKey(@CurrentUser UserDTO userDTO, @RequestParam String key) {
        return new ResponseEntity<>(redisService.hasKey(key), HttpStatus.OK);
    }

    @ApiOperation(value = "delKey")
    @DeleteMapping("delKey")
    public ResponseEntity<Boolean> deleteKey(@CurrentUser UserDTO userDTO, @RequestParam String key) {
        return new ResponseEntity<>(redisService.delete(key), HttpStatus.OK);
    }
}
