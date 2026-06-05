package com.flower.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.base.ResponseResult;
import com.flower.dto.LoginDto;
import com.flower.dto.UserDto;
import com.flower.entity.User;
import com.flower.mapper.UserMapper;
import com.flower.utils.JwtUtil;
import com.flower.vo.LoginVo;
import com.flower.vo.UserVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Value("${jwt.expiration}")
    private long expiration;

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseResult<LoginVo> login(LoginDto loginDto) {
        User user = this.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, loginDto.getUsername()));
        if (user == null) {
            return ResponseResult.error("用户名或密码错误");
        }
        if (user.getStatus() == 0) {
            return ResponseResult.error("账号已被禁用");
        }
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return ResponseResult.error("用户名或密码错误");
        }
        // Generate JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("username", user.getUsername());
        String token = JwtUtil.createJWT(claims);

        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        loginVo.setUserId(user.getId());
        loginVo.setUsername(user.getUsername());
        return ResponseResult.success(loginVo);
    }

    public ResponseResult<Void> register(UserDto userDto) {
        long count = this.count(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, userDto.getUsername()));
        if (count > 0) {
            return ResponseResult.error("用户名已存在");
        }
        User user = BeanUtil.toBean(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setStatus(1);
        this.save(user);
        return ResponseResult.success();
    }

    public UserVo getUserById(Long id) {
        User user = this.getById(id);
        return BeanUtil.toBean(user, UserVo.class);
    }

    public User findByUsername(String username) {
        return this.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getStatus, 1));
    }
}
