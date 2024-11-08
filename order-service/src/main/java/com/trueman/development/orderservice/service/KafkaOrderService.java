package com.trueman.development.orderservice.service;

import com.trueman.development.orderservice.model.Order;
//import com.trueman.development.orderservice.repository.KafkaOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaOrderService {

    @Value("${topic.send-payment}")
    private String sendClientTopic;

//    private final KafkaOrderRepository kafkaOrderRepository;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrderEvent(Order order) {
//        kafkaOrderRepository.save(order);

        log.info("OrderService стартовал !");

        kafkaTemplate.send(sendClientTopic, order);
    }
}
