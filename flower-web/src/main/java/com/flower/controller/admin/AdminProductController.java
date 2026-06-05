package com.flower.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flower.base.PageBean;
import com.flower.base.ResponseResult;
import com.flower.dto.ProductDto;
import com.flower.entity.Product;
import com.flower.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/products")
@Slf4j
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseResult<PageBean<Product>> list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        Page<Product> p = productService.page(new Page<>(page, size));
        return ResponseResult.success(new PageBean<>(p.getTotal(), p.getRecords(), page, size));
    }

    @PostMapping
    public ResponseResult<Void> create(@RequestBody ProductDto dto) {
        Product product = BeanUtil.toBean(dto, Product.class);
        product.setStatus(1);
        productService.save(product);
        return ResponseResult.success();
    }

    @PutMapping("/{id}")
    public ResponseResult<Void> update(@PathVariable Long id, @RequestBody ProductDto dto) {
        Product product = BeanUtil.toBean(dto, Product.class);
        product.setId(id);
        productService.updateById(product);
        return ResponseResult.success();
    }

    @DeleteMapping("/{id}")
    public ResponseResult<Void> delete(@PathVariable Long id) {
        productService.removeById(id);
        return ResponseResult.success();
    }
}
