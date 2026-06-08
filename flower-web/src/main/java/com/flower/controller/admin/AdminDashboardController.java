package com.flower.controller.admin;

import com.flower.base.ResponseResult;
import com.flower.service.OrderService;
import com.flower.service.ProductService;
import com.flower.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/dashboard")
@RequiredArgsConstructor
public class AdminDashboardController {

    private final ProductService productService;
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping
    public ResponseResult<Map<String, Object>> stats() {
        Map<String, Object> data = new HashMap<>();
        data.put("productCount", productService.count());
        data.put("orderCount", orderService.count());
        data.put("userCount", userService.count());
        return ResponseResult.success(data);
    }
}