package com.example.hp.jenkinstomq.config;

import com.example.hp.jenkinstomq.dto.ScheduleParam;
import com.example.hp.jenkinstomq.enums.ScheduleTypeEnum;
import com.example.hp.jenkinstomq.service.ScheduleExecutor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "scheduled-queue")
public class DirectRabbitConsumer {

    @RabbitHandler
    public void process(Object message){
        ScheduleParam param = (ScheduleParam) message;
        ScheduleExecutor executor = ScheduleTypeEnum.getExecutor(param.getType());
        executor.execute(((ScheduleParam) message).getParam());
    }

}
