package com.flower.controller.user;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flower.base.ResponseResult;
import com.flower.dto.OrderSubmitDto;
import com.flower.entity.Order;
import com.flower.entity.OrderItem;
import com.flower.entity.Product;
import com.flower.service.OrderItemService;
import com.flower.service.OrderService;
import com.flower.service.ProductService;
import com.flower.utils.RequestHolder;
import com.flower.vo.OrderVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final ProductService productService;

    @GetMapping("/orders")
    public ResponseResult<List<OrderVo>> list() {
        Long userId = RequestHolder.getCurrentUserId();
        List<Order> orders = orderService.list(new LambdaQueryWrapper<Order>()
                .eq(Order::getUserId, userId)
                .orderByDesc(Order::getCreateTime));
        List<OrderVo> vos = orders.stream().map(o -> {
            OrderVo vo = BeanUtil.toBean(o, OrderVo.class);
            List<OrderItem> items = orderItemService.list(
                    new LambdaQueryWrapper<OrderItem>().eq(OrderItem::getOrderId, o.getId()));
            vo.setItems(items.stream().map(i -> {
                OrderVo.OrderItemVo itemVo = BeanUtil.toBean(i, OrderVo.OrderItemVo.class);
                Product p = productService.getById(i.getProductId());
                if (p != null) {
                    itemVo.setProductName(p.getName());
                    itemVo.setProductCover(p.getCover());
                }
                return itemVo;
            }).collect(Collectors.toList()));
            return vo;
        }).collect(Collectors.toList());
        return ResponseResult.success(vos);
    }

    @PostMapping("/order/submit")
    @Transactional
    public ResponseResult<Void> submit(@RequestBody OrderSubmitDto dto) {
        Long userId = RequestHolder.getCurrentUserId();
        BigDecimal total = BigDecimal.ZERO;

        for (OrderSubmitDto.OrderItemDto item : dto.getItems()) {
            Product p = productService.getById(item.getProductId());
            if (p == null || p.getStock() < item.getQuantity()) {
                return ResponseResult.error("商品库存不足");
            }
            total = total.add(p.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        Order order = new Order();
        order.setOrderNo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + userId);
        order.setUserId(userId);
        order.setTotalAmount(total);
        order.setStatus(1);
        order.setDeliveryType(dto.getDeliveryType());
        order.setAddress(dto.getAddress());
        orderService.save(order);

        for (OrderSubmitDto.OrderItemDto item : dto.getItems()) {
            Product p = productService.getById(item.getProductId());
            OrderItem oi = new OrderItem();
            oi.setOrderId(order.getId());
            oi.setProductId(item.getProductId());
            oi.setQuantity(item.getQuantity());
            oi.setPrice(p.getPrice());
            orderItemService.save(oi);

            p.setStock(p.getStock() - item.getQuantity());
            productService.updateById(p);
        }

        return ResponseResult.success();
    }

    @PostMapping("/order/pay/{id}")
    public ResponseResult<Void> pay(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order == null || order.getStatus() != 1) {
            return ResponseResult.error("订单状态异常");
        }
        order.setStatus(2);
        orderService.updateById(order);
        return ResponseResult.success();
    }
}
