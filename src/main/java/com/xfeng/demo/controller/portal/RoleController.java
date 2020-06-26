package com.xfeng.demo.controller.portal;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xfeng.demo.annotation.CurrentUser;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.model.entity.Role;
import com.xfeng.demo.service.RoleService;
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
 * @date 2020-06-23
 */
@RestController
@RequiredArgsConstructor
@Api(description = "角色接口 ")
@RequestMapping("portal/role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    @ApiOperation(value = "分页查询角色")
    @RequiresPermissions("role.view")
    public ResponseEntity<IPage<Role>> page(@CurrentUser UserDTO userDTO, @RequestParam(required = false) String word, Pageable pageable) {
        return new ResponseEntity<>(roleService.page(word, pageable), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "新增角色")
    @RequiresPermissions("role.add")
    public ResponseEntity<Role> insert(@CurrentUser UserDTO userDTO, @RequestBody Role role) {
        return new ResponseEntity<>(roleService.insert(role), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "修改角色")
    @RequiresPermissions("role.edit")
    public ResponseEntity<Role> edit(@CurrentUser UserDTO userDTO, @RequestBody Role role) {
        return new ResponseEntity<>(roleService.edit(role), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "删除角色")
    @RequiresPermissions("role.delete")
    public ResponseEntity<Integer> delete(@CurrentUser UserDTO userDTO, Long id) {
        return new ResponseEntity<>(roleService.delete(id), HttpStatus.OK);
    }
}
