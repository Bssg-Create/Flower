package com.flower.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.entity.ThemeProduct;
import com.flower.mapper.ThemeProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ThemeProductService extends ServiceImpl<ThemeProductMapper, ThemeProduct> {
}
