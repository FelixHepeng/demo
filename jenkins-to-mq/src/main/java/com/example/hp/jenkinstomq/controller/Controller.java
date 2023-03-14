package com.example.hp.jenkinstomq.controller;


import com.example.hp.jenkinstomq.service.impl.JenkinsInfoAcquireServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @Autowired
    JenkinsInfoAcquireServiceImpl jenkinsInfoAcquireService;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        jenkinsInfoAcquireService.getSystemInfo();

        return "success";
    }

}
