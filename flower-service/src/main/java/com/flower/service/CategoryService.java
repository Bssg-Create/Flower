package com.flower.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.entity.Category;
import com.flower.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {
}
