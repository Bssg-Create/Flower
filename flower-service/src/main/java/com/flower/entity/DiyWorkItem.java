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

    @TableField("created_at")
    private LocalDateTime createTime;
    @TableField(exist = false)
    private Long createBy;
    @TableField(exist = false)
    private String remark;
}
