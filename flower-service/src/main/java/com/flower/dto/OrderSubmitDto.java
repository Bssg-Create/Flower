package com.flower.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderSubmitDto {
    private String address;
    private String deliveryType;
    private List<OrderItemDto> items;
    private String remark;

    @Data
    public static class OrderItemDto {
        private Long productId;
        private Integer quantity;
    }
}
