package com.trueman.development.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class TestController {

    @GetMapping("/name")
    public String test() {
        return "OrderController test";
    }
}
