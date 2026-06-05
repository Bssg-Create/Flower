package com.flower.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.entity.Review;
import com.flower.mapper.ReviewMapper;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends ServiceImpl<ReviewMapper, Review> {
}
