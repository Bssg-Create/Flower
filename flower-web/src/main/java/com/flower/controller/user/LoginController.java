package com.flower.controller.user;

import com.flower.base.ResponseResult;
import com.flower.dto.LoginDto;
import com.flower.dto.UserDto;
import com.flower.service.UserService;
import com.flower.vo.LoginVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseResult<LoginVo> login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    @PostMapping("/register")
    public ResponseResult<Void> register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }
}
