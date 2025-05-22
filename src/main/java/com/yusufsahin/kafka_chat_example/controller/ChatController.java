package com.yusufsahin.kafka_chat_example.controller;

import com.yusufsahin.kafka_chat_example.model.ChatMessage;
import com.yusufsahin.kafka_chat_example.service.ChatProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatProducer chatProducer;

    public ChatController(ChatProducer chatProducer) {
        this.chatProducer = chatProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody ChatMessage message) {
        chatProducer.sendMessage(message.getSender(), message.getMessage());
        return "Message sent successfully";
    }
}
