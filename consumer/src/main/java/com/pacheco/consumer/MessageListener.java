package com.pacheco.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageListener {
    
    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics="${topic.name.consumer}", groupId = "group_id")
    public void consumer(Message message) {
        log.info(String.format("A seguinte mensagem foi enviada em %s: %s", 
            message.getCreatedAt().toString(), message.getMessage()));
    }
}
