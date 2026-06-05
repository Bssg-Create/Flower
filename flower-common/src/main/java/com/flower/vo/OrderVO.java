package com.flower.vo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderVO {
    private Long id;
    private String orderNo;
    private BigDecimal totalAmount;
    private Integer status;
    private String statusDesc;
    private String deliveryType;
    private String address;
    private LocalDateTime createdAt;
    private List<OrderItemVO> items;
    private String trackingNo;
    private Integer logisticsStatus;

    @Data
    public static class OrderItemVO {
        private Long productId;
        private String productName;
        private String productCover;
        private Integer quantity;
        private BigDecimal price;
    }
}
