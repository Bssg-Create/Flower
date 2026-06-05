package com.flower.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("diy_works")
public class DiyWorks {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long packagingId;
    private BigDecimal totalPrice;
    private String snapshot;
    private Integer status;

    @TableField("created_at")
    private LocalDateTime createTime;
    @TableField("updated_at")
    private LocalDateTime updateTime;
    private Long createBy;
    private Long updateBy;
    private String remark;
}
