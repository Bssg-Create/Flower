package com.flower.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus implements BasicEnum {
    PENDING_PAY(1, "待付款"),
    PENDING_SHIP(2, "待发货"),
    IN_TRANSIT(3, "运输中"),
    COMPLETED(4, "已完成"),
    CANCELLED(5, "已取消");

    private final int code;
    private final String msg;
}
