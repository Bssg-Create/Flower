package com.flower.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonStatus {
    ENABLED(1, "启用/上架"),
    DISABLED(0, "禁用/下架");

    private final int code;
    private final String desc;
}
