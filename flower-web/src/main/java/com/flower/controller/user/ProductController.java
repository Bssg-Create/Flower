package com.flower.controller.user;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flower.base.PageBean;
import com.flower.base.ResponseResult;
import com.flower.dto.ProductQueryDto;
import com.flower.entity.Product;
import com.flower.service.ProductService;
import com.flower.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseResult<PageBean<ProductVo>> listProducts(ProductQueryDto queryDto) {
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        if (queryDto.getCategoryId() != null) {
            wrapper.eq(Product::getCategoryId, queryDto.getCategoryId());
        }
        if (StringUtils.hasText(queryDto.getHolidayTag())) {
            wrapper.eq(Product::getHolidayTag, queryDto.getHolidayTag());
        }
        if (StringUtils.hasText(queryDto.getKeyword())) {
            wrapper.like(Product::getName, queryDto.getKeyword());
        }
        wrapper.eq(Product::getStatus, 1);

        if ("price_asc".equals(queryDto.getSort())) {
            wrapper.orderByAsc(Product::getPrice);
        } else if ("price_desc".equals(queryDto.getSort())) {
            wrapper.orderByDesc(Product::getPrice);
        }

        Page<Product> page = new Page<>(queryDto.getPage(), queryDto.getSize());
        productService.page(page, wrapper);

        List<ProductVo> vos = page.getRecords().stream()
                .map(p -> BeanUtil.toBean(p, ProductVo.class))
                .collect(Collectors.toList());

        return ResponseResult.success(new PageBean<>(page.getTotal(), vos, queryDto.getPage(), queryDto.getSize()));
    }

    @GetMapping("/product/{id}")
    public ResponseResult<ProductVo> getProduct(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product == null) {
            return ResponseResult.error("商品不存在");
        }
        return ResponseResult.success(BeanUtil.toBean(product, ProductVo.class));
    }
}
