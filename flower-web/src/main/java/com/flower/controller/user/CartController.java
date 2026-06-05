package com.flower.controller.user;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flower.base.ResponseResult;
import com.flower.dto.CartDto;
import com.flower.entity.Cart;
import com.flower.entity.Product;
import com.flower.service.CartService;
import com.flower.service.ProductService;
import com.flower.utils.RequestHolder;
import com.flower.vo.CartVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cart")
@Slf4j
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping
    public ResponseResult<List<CartVo>> list() {
        Long userId = RequestHolder.getCurrentUserId();
        List<Cart> carts = cartService.list(new LambdaQueryWrapper<Cart>()
                .eq(Cart::getUserId, userId));
        List<CartVo> vos = carts.stream().map(c -> {
            CartVo vo = BeanUtil.toBean(c, CartVo.class);
            Product p = productService.getById(c.getProductId());
            if (p != null) {
                vo.setProductName(p.getName());
                vo.setProductCover(p.getCover());
                vo.setPrice(p.getPrice());
                vo.setSubtotal(p.getPrice().multiply(BigDecimal.valueOf(c.getQuantity())));
            }
            return vo;
        }).collect(Collectors.toList());
        return ResponseResult.success(vos);
    }

    @PostMapping("/add")
    public ResponseResult<Void> add(@RequestBody CartDto cartDto) {
        Long userId = RequestHolder.getCurrentUserId();
        Cart exist = cartService.getOne(new LambdaQueryWrapper<Cart>()
                .eq(Cart::getUserId, userId)
                .eq(Cart::getProductId, cartDto.getProductId()));
        if (exist != null) {
            exist.setQuantity(exist.getQuantity() + cartDto.getQuantity());
            cartService.updateById(exist);
        } else {
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setProductId(cartDto.getProductId());
            cart.setQuantity(cartDto.getQuantity());
            cartService.save(cart);
        }
        return ResponseResult.success();
    }

    @DeleteMapping("/{id}")
    public ResponseResult<Void> remove(@PathVariable Long id) {
        cartService.removeById(id);
        return ResponseResult.success();
    }
}
