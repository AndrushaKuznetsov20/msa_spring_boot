package com.trueman.development.paymentservice.service;

import com.trueman.development.paymentservice.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaPaymentService {

    @Value("${topic.send-payment-response}")
    private String sendClientTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPaymentEvent(Order order) {
        log.info("PaymentService стартовал");

        kafkaTemplate.send(sendClientTopic, order);
    }
}
