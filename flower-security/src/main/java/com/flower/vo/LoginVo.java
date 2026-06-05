package com.flower.vo;

import lombok.Data;

@Data
public class LoginVo {
    private String token;
    private Long userId;
    private String username;
}
