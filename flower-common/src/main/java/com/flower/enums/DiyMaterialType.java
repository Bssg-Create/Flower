package com.flower.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiyMaterialType implements BasicEnum {
    FLOWER(1, "花材"),
    RIBBON(2, "丝带"),
    CARD(3, "贺卡"),
    LIGHT(4, "灯串");

    private final int code;
    private final String msg;
}