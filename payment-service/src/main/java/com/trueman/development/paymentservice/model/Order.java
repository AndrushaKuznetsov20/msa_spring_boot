package com.trueman.development.paymentservice.model;

//import jakarta.persistence.*;
import lombok.Data;

@Data
public class Order {
    private Long id;

    private String name;

    private double price;

}
