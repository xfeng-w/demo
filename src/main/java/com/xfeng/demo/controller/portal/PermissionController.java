package com.xfeng.demo.controller.portal;

import com.xfeng.demo.annotation.CurrentUser;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.model.entity.Permission;
import com.xfeng.demo.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuefeng.wang
 * @date 2020-06-23
 */
@RestController
@RequiredArgsConstructor
@Api("权限接口 ")
@RequestMapping("portal/permission")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    @ApiOperation(value = "新增权限")
    @RequiresPermissions("permission.add")
    public ResponseEntity<Permission> insert(@CurrentUser UserDTO userDTO, @RequestBody Permission permission) {
        return new ResponseEntity<>(permissionService.insert(permission), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "修改权限")
    @RequiresPermissions("permission.edit")
    public ResponseEntity<Permission> update(@CurrentUser UserDTO userDTO, @RequestBody Permission permission) {
        return new ResponseEntity<>(permissionService.update(permission), HttpStatus.OK);
    }
}
