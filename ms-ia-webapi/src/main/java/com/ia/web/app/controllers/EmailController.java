package com.ia.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ia.web.app.messaging.sender.EmailQueueSender;
import com.ia.web.app.payload.request.EmailRequest;
import com.ia.web.app.services.UserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Slf4j
public class EmailController {
	@Autowired
	UserService userService;

	@Autowired
	private EmailQueueSender emailQueueSender;

	/**
	 * Recupera informaçõe do request para enviar para a fila (RabbitMQ), 
	 * e, se for para enviar para todos os usuários admin, faz uma busca na base 
	 * e cria uam requisição para cada usuário admin para ser enviado para a fila
	 * 
	 * @param emailRequest
	 */
	@PostMapping("/email")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public void sendMessage(@Valid @RequestBody EmailRequest emailRequest) {
		List<EmailRequest> listEmailRequest = userService.getUsersAdmin(emailRequest);
		listEmailRequest.forEach(emailReq -> {
			try {
				emailQueueSender.send(emailReq);
			} catch (AmqpException | JsonProcessingException e) {
				log.error("Erro durante envio para fila no RabbitMQ ", e);
			}
		});

	}
}
