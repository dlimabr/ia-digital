package com.ia.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Aplicação responsável por consumir mensagens da fila do RabbitMq e enviar
 * email para os usuários de acordo com dados vindos da mensage no formato JSON
 * 
 * @author danielle.lima
 *
 */
@SpringBootApplication
@EnableRabbit
public class ConsumerAppConfig {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAppConfig.class, args);
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
