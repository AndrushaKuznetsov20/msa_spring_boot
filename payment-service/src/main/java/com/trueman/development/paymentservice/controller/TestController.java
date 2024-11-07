package com.trueman.development.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class TestController {

    @GetMapping("/name")
    public String test() {
        return "Payment Service Name";
    }
}
