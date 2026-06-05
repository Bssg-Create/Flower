package com.flower.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("diy_material")
public class DiyMaterial {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String image;
    private BigDecimal price;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
