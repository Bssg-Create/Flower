package com.flower.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryType {
    EXPRESS("express", "快递配送"),
    LOCAL("local", "同城速递"),
    SELF("self", "到店自取");

    private final String code;
    private final String desc;
}
