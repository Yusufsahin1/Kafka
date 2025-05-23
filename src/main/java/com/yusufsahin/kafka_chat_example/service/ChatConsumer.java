package com.yusufsahin.kafka_chat_example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChatConsumer {

    @KafkaListener(topics = "chat-topic", groupId = "chat-group")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
