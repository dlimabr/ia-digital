package com.ia.messaging.consumer;

import javax.mail.MessagingException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ia.messaging.consumer.payload.EmailRequest;
import com.ia.messaging.consumer.services.EmailService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ConfigurationProperties
@RefreshScope
public class EmailConsumer {
	 @Autowired
	 private EmailService emailService;
	 
	 @Autowired
	 private ObjectMapper mapper;
	 
	 @Value("${email.assunto}")
	 private String assunto;
	 
    @RabbitListener(queues = {"${queue.email.name}"})
    public void receive(@Payload String message) {
        log.info("message: " + message);    	
        try {
        	EmailRequest emailRequest = mapper.readValue(message, EmailRequest.class);    	
            emailService.sendMail(emailRequest.getEmail(), assunto, emailRequest.getMessage());
        } catch (MessagingException e) {
        	 log.error("Erro durante envio do email", e);
        } catch (JsonMappingException e) {
        	log.error("Erro ao mapear os dados da mensagem durante envio do email", e);
		} catch (JsonProcessingException e) {
			log.error("Erro ao fazer parser dos dados da mensagem durante envio do email", e);
		}
    }
}