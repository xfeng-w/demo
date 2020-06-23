package com.xfeng.demo.controller.portal;

import com.xfeng.demo.enums.ResultCode;
import com.xfeng.demo.exception.APIException;
import com.xfeng.demo.model.dto.AccountDTO;
import com.xfeng.demo.model.dto.UserDTO;
import com.xfeng.demo.model.entity.User;
import com.xfeng.demo.service.UserService;
import com.xfeng.demo.util.CookieUtils;
import com.xfeng.demo.util.JacksonUtils;
import com.xfeng.demo.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author xuefeng.wang
 * @date 2020-06-20
 */
@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    private final JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated AccountDTO account) {
        User user = userService.selectByAccount(account);
        if (Objects.isNull(user)) {
            throw new APIException(ResultCode.FAILED.getCode(), "账号或密码错误！");
        }
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        String token = jwtUtils.sign(JacksonUtils.write2JsonString(userDto));
        CookieUtils.setCookie(request, response, "token", token);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request,response,"token");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
