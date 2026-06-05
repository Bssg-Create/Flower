package com.flower.base;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class PageBean<T> implements Serializable {

    private Long total;
    private List<T> records;
    private Integer page;
    private Integer size;

    public PageBean(Long total, List<T> records, Integer page, Integer size) {
        this.total = total;
        this.records = records;
        this.page = page;
        this.size = size;
    }
}
