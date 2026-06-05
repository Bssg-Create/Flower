package com.flower.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("order_logistics")
public class OrderLogistics {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orderId;
    private String trackingNo;
    private Integer status;
    private String records;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
