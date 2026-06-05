package com.flower.config;

import com.flower.entity.Admin;
import com.flower.entity.User;
import com.flower.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final com.flower.mapper.UserMapper userMapper;

    @Override
    public void run(String... args) {
        // Create test user if none exists
        long userCount = userService.count();
        if (userCount == 0) {
            User user = new User();
            user.setUsername("testuser");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setPhone("13800138000");
            user.setStatus(1);
            userService.save(user);
            log.info("默认测试用户已创建: testuser / 123456");
        }
    }
}