package com.yusufsahin.kafka_chat_example.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatProducer {

    private static final String TOPIC = "chat-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ChatProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String sender, String message) {
        String fullMessage = sender + ": " + message;
        kafkaTemplate.send(TOPIC, fullMessage);
    }

}
