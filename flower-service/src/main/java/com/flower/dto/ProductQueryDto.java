package com.flower.dto;

import lombok.Data;

@Data
public class ProductQueryDto {
    private Long categoryId;
    private String keyword;
    private String holidayTag;
    private String sort;
    private Integer page = 1;
    private Integer size = 10;
}
