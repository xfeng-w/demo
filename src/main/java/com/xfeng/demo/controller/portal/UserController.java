package com.xfeng.demo.controller.portal;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xfeng.demo.annotation.CurrentUser;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.model.entity.User;
import com.xfeng.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuefeng.wang
 * @date 2020-05-22
 */

@Api("用户接口 ")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "portal/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "分页查询用户")
    @RequiresPermissions("user.view")
    public ResponseEntity<IPage<User>> page(@CurrentUser UserDTO userDTO, @RequestParam(required = false) String word, Pageable pageable) {
        return new ResponseEntity<>(userService.page(word, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "根据id查询用户")
    @RequiresPermissions("user.view")
    public ResponseEntity<User> info(@CurrentUser UserDTO userDTO, @PathVariable Long id) {
        return new ResponseEntity<>(userService.info(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "新增用户")
    @RequiresPermissions("user.add")
    public ResponseEntity<User> insert(@CurrentUser UserDTO userDTO, @RequestBody User user) {
        return new ResponseEntity<>(userService.insertUser(user), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "修改用户")
    @RequiresPermissions("user.edit")
    public ResponseEntity<User> edit(@CurrentUser UserDTO userDTO, @RequestBody User user) {
        return new ResponseEntity<>(userService.editUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation(value = "删除用户")
    @RequiresPermissions("user.delete")
    public ResponseEntity<Integer> delete(@CurrentUser UserDTO userDTO, @PathVariable Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
