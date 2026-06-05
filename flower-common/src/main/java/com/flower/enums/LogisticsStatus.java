package com.flower.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogisticsStatus {
    PENDING_COLLECT(1, "待揽收"),
    IN_TRANSIT(2, "运输中"),
    DELIVERING(3, "派送中"),
    SIGNED(4, "已签收");

    private final int code;
    private final String desc;
}
