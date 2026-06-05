package com.flower.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDto {
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String cover;
    private String holidayTag;
}
