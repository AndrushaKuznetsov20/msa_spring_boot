package com.trueman.development.orderservice.repository;

import com.trueman.development.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaOrderRepository extends JpaRepository<Order, Long> {
}
