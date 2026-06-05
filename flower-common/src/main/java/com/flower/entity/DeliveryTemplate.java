package com.flower.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("delivery_template")
public class DeliveryTemplate {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private Double firstWeight;
    private BigDecimal firstPrice;
    private BigDecimal continuePrice;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
