package com.flower.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class DiyWorksDto {
    private Long packagingId;
    private BigDecimal totalPrice;
    private String snapshot;
    private List<WorkItem> items;

    @Data
    public static class WorkItem {
        private Long materialId;
        private Double x;
        private Double y;
        private Double scale;
        private Double rotation;
        private Integer zIndex;
    }
}
