package com.trueman.development.orderservice.model;

//import jakarta.persistence.*;
import lombok.Data;

@Data
//@Entity
//@Table(name = "orders")
public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "price")
    private double price;

}
