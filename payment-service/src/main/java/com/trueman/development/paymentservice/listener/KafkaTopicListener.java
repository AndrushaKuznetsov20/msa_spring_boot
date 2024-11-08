package com.trueman.development.paymentservice.listener;

import com.trueman.development.paymentservice.model.Order;
import com.trueman.development.paymentservice.model.Payment;
import com.trueman.development.paymentservice.model.enums.OrderStatus;
import com.trueman.development.paymentservice.repository.PaymentRepository;
import com.trueman.development.paymentservice.service.KafkaPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaTopicListener {
    private static final String TOPIC_CREATE_ORDER = "${topic.send-payment}";
    private static final String KAFKA_CONSUMER_GROUP_ID= "${spring.kafka.consumer.group-id}";

    private final KafkaPaymentService kafkaPaymentService;
    private final PaymentRepository paymentRepository;

    @KafkaListener(
            topics = TOPIC_CREATE_ORDER,
            groupId = KAFKA_CONSUMER_GROUP_ID,
            properties = {"spring.json.value.default.type=com.trueman.development.paymentservice.model.Order"}
    )
    public void getOrder(Order order) {
        log.info("Получено сообщение:{}", order);

        if(order.getBalance() >= order.getPrice()) {
            order.setStatus(OrderStatus.PAID);
        } else {
            order.setStatus(OrderStatus.CANCELLED);
        }

        Payment payment = new Payment();

        payment.setOrderName(order.getName());
        payment.setUserId(order.getUserId());
        payment.setStatus(order.getStatus().toString());

        paymentRepository.save(payment);

        kafkaPaymentService.sendPaymentEvent(order);
    }
}
