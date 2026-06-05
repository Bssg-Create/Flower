package com.flower.vo;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CartVo {
    private Long id;
    private Long productId;
    private String productName;
    private String productCover;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;
}
