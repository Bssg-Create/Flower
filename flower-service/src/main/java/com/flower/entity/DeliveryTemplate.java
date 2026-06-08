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
@TableName("delivery_template")
public class DeliveryTemplate {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private Double firstWeight;
    private BigDecimal firstPrice;
    private BigDecimal continuePrice;

    @TableField("created_at")
    private LocalDateTime createTime;
    @TableField("updated_at")
    private LocalDateTime updateTime;
    @TableField(exist = false)
    private Long createBy;
    @TableField(exist = false)
    private Long updateBy;
    @TableField(exist = false)
    private String remark;
}
