package com.flower.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryType implements BasicEnum {
    EXPRESS(1, "快递配送"),
    LOCAL(2, "同城速递"),
    SELF(3, "到店自取");

    private final int code;
    private final String msg;
}