package com.flower.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.entity.Order;
import com.flower.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
}
