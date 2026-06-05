package com.flower.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
public class CartAddDTO {

    @NotNull(message = "商品ID不能为空")
    private Long productId;

    @Min(value = 1, message = "数量最少为1")
    private Integer quantity = 1;
}
