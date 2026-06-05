package com.flower.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("theme_product")
public class ThemeProduct {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long themeId;
    private Long productId;
    private Integer sort;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
}
