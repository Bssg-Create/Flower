package com.flower.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserVo {
    private Long id;
    private String username;
    private String phone;
    private String avatar;
    private Integer status;
    private LocalDateTime createTime;
}
