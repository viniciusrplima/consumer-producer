package com.pacheco.producer;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PeriodicSender {
    
    @Autowired
    private MessageProducer messageProducer;

    @PostConstruct
    public void periodicSend() {
        int messageCounter = 0;

        while (true) {
            try {
                messageProducer.send("Mensagem de número " + messageCounter);
                messageCounter++;
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

}
