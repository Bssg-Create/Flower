package com.flower.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("theme_product")
public class ThemeProduct {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long themeId;
    private Long productId;
    private Integer sort;

    @TableField("created_at")
    private LocalDateTime createTime;
    private Long createBy;
    private String remark;
}
