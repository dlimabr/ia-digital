package com.ia.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.web.app.payload.request.EmailRequest;
import com.ia.web.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public List<EmailRequest> getUsersAdmin(EmailRequest emailRequest) {

		List<EmailRequest> listEmailRequest = new ArrayList<EmailRequest>();

		if (emailRequest.getAllUsersAdmin() != null && emailRequest.getAllUsersAdmin()) {
			userRepository.findByIsAdmin(true).forEach(user -> {
				EmailRequest emailReq = new EmailRequest(user.getUsername(), user.getEmail(),
						emailRequest.getMessage());
				listEmailRequest.add(emailReq);
			});

		} else {
			listEmailRequest.add(emailRequest);
		}
		return listEmailRequest;
	}

}
