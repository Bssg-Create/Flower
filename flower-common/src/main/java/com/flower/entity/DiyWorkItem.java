package com.flower.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("diy_work_item")
public class DiyWorkItem {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long workId;
    private Long materialId;
    private Double x;
    private Double y;
    private Double scale;
    private Double rotation;
    private Integer zIndex;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
}
