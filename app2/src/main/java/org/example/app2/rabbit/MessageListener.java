package org.example.app2.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = "test-queue")
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
    }
}