package com.trueman.development.orderservice.controller;

import com.trueman.development.orderservice.model.Order;
import com.trueman.development.orderservice.service.KafkaOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class KafkaOrderController {

    private final KafkaOrderService kafkaOrderService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        return kafkaOrderService.sendOrderEvent(order);
    }
}
