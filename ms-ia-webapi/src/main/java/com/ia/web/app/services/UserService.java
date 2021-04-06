package com.ia.web.app.services;

import java.util.List;

import com.ia.web.app.payload.request.EmailRequest;

public interface UserService {
	 public List<EmailRequest> getUsersAdmin(EmailRequest emailRequest);
}
