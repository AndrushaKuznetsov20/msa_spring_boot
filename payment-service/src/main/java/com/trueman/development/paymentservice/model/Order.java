package com.trueman.development.paymentservice.model;

//import jakarta.persistence.*;
import com.trueman.development.paymentservice.model.enums.OrderStatus;
import lombok.Data;

@Data
public class Order {
    private Long id;

    private String name;

    private double price;

    private Long userId;

    private double balance;

    private OrderStatus status;
}
