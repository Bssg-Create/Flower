package com.flower.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;

@Data
public class PageDTO {

    @Min(value = 1, message = "页码最小为1")
    private Integer page = 1;

    @Min(value = 1, message = "每页条数最小为1")
    private Integer size = 10;
}
