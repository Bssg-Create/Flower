package com.flower.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiyMaterialType {
    FLOWER("flower", "花材"),
    RIBBON("ribbon", "丝带"),
    CARD("card", "贺卡"),
    LIGHT("light", "灯串");

    private final String code;
    private final String desc;
}
