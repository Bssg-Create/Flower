package com.flower.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long productId;
    private Integer rating;
    private String content;
    private String images;
}
