package com.example.hp.jenkinstomq.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//@RabbitListener(queues = "jenkins-build-post-queue")
public class DirectRabbitConsumer {
    @RabbitHandler
    public void process(Object message) throws JsonProcessingException {
        System.out.println(message);

    }

}
