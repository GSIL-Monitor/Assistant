package com.rongzi.monitor.core.mq.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class DataSend implements RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;


    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("Message id:" + correlationData.getId()+"Send Message Success");
        } else {
            System.out.println("Send Message Error:" + cause);
        }
    }


    public void sendData(String exchange,String topic, String message){

        rabbitTemplate.setConfirmCallback(this);

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

        this.rabbitTemplate.convertAndSend(exchange, topic, message, correlationData);

    }

}

