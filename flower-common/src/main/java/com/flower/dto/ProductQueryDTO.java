package com.flower.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductQueryDTO extends PageDTO {

    private Long categoryId;
    private String keyword;
    private String holidayTag;
    private String sort;  // price_asc / price_desc / newest
}
