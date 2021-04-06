package com.ia.web.app.messaging.sender;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ia.web.app.payload.request.EmailRequest;

@Component
public class EmailQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private Queue queue;
    
    private ObjectMapper om = new ObjectMapper();

    public void send(EmailRequest message) throws AmqpException, JsonProcessingException {    	
        rabbitTemplate.convertAndSend(this.queue.getName(), om.writeValueAsString(message));
    }
}