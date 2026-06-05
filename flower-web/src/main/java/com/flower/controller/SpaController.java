package com.flower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {

    @GetMapping(value = {"/", "/login", "/products", "/product/**",
                          "/diy", "/cart", "/orders",
                          "/admin", "/admin/**"})
    public String forward() {
        return "forward:/index.html";
    }
}