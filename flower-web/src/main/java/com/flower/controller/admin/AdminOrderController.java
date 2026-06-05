package com.flower.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flower.base.PageBean;
import com.flower.base.ResponseResult;
import com.flower.entity.Order;
import com.flower.entity.OrderItem;
import com.flower.service.OrderItemService;
import com.flower.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/orders")
@Slf4j
@RequiredArgsConstructor
public class AdminOrderController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseResult<PageBean<Order>> list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) Integer status) {
        Page<Order> p;
        if (status != null) {
            p = orderService.page(new Page<>(page, size),
                    new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<Order>()
                            .eq(Order::getStatus, status).orderByDesc(Order::getCreateTime));
        } else {
            p = orderService.page(new Page<>(page, size),
                    new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<Order>()
                            .orderByDesc(Order::getCreateTime));
        }
        return ResponseResult.success(new PageBean<>(p.getTotal(), p.getRecords(), page, size));
    }

    @PutMapping("/{id}/status")
    public ResponseResult<Void> updateStatus(@PathVariable Long id, @RequestParam Integer status) {
        Order order = orderService.getById(id);
        if (order != null) {
            order.setStatus(status);
            orderService.updateById(order);
        }
        return ResponseResult.success();
    }
}
