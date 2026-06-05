package com.flower.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class OrderSubmitDTO {

    @NotBlank(message = "收货地址不能为空")
    private String address;

    @NotBlank(message = "配送方式不能为空")
    private String deliveryType;

    @NotEmpty(message = "订单明细不能为空")
    private List<OrderItemDTO> items;

    private String remark;

    @Data
    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;
    }
}
