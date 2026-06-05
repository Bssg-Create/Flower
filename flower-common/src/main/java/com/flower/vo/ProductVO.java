package com.flower.vo;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductVO {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String cover;
    private String holidayTag;
    private List<String> images;
}
