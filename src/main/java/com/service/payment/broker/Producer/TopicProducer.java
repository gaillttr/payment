package com.service.payment.broker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.payment.model.Payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Payment payment) {
        ObjectMapper objectMapper = new ObjectMapper();
        String orderJson = null;
        try {
            orderJson = objectMapper.writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            log.error("Error in TopicProducer.sendMessage()");
            log.error(e.getMessage());
            e.printStackTrace();
        }
        log.info("Payment Detail {}", orderJson);
        System.out.println(
            String.format("##########\nProduced Payment Recieved -> %s\n##########", orderJson));
        this.kafkaTemplate.send(topicName, "Produced Payment Recieved -> ",orderJson);
    }
}
