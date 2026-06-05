package com.flower.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.entity.Cart;
import com.flower.mapper.CartMapper;
import org.springframework.stereotype.Service;

@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
}
