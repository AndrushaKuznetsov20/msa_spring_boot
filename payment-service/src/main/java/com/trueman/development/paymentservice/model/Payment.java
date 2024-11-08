package com.trueman.development.paymentservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderName")
    private String orderName;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "status")
    private String status;
}
