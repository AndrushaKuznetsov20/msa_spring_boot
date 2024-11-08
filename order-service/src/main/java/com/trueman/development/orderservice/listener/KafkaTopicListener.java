package com.trueman.development.orderservice.listener;

import com.trueman.development.orderservice.model.Order;
import com.trueman.development.orderservice.model.enums.OrderStatus;
import com.trueman.development.orderservice.repository.KafkaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaTopicListener {
    private static final String TOPIC_CREATE_ORDER = "${topic.send-payment-response}";
    private static final String KAFKA_CONSUMER_GROUP_ID= "${spring.kafka.consumer.group-id}";

    private final KafkaOrderRepository kafkaOrderRepository;

    @KafkaListener(
            topics = TOPIC_CREATE_ORDER,
            groupId = KAFKA_CONSUMER_GROUP_ID,
            properties = {"spring.json.value.default.type=com.trueman.development.orderservice.model.Order"}
    )
    public ResponseEntity<?> getOrderPayment(Order order) {
        if(order.getStatus() == OrderStatus.PAID) {
            return ResponseEntity.ok("Товар успешно оплачен:" + order.getName());
        } else {
            kafkaOrderRepository.delete(order);
            return ResponseEntity.ok("Товар не оплачен, недостаточно средтва на вашем счету!" + order.getName());
        }
    }
}
