package com.ia.web.app;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Aplicação de login, cadastro, segurança, 
 * gerenciamento da sessão e produtor de mensagens (RabbitMQ)
 * 
 * @author danielle.lima
 *
 */
@SpringBootApplication
@EnableJpaAuditing
@ConfigurationProperties
@RefreshScope
public class WebApiApplication {

	@Value("${queue.email.name}")
	private String emailQueue;

	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
	}

	@Bean
	public Queue queue() {
		return new Queue(emailQueue, true);
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
}
