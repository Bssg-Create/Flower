package com.flower.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.entity.ProductImage;
import com.flower.mapper.ProductImageMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService extends ServiceImpl<ProductImageMapper, ProductImage> {
}
