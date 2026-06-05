package com.flower.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("diy_works")
public class DiyWorks {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long packagingId;
    private BigDecimal totalPrice;
    private String snapshot;
    private Integer status;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
