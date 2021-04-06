package com.ia.web.app.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class EmailRequest {
	private String username;
	
	private String email;
		
	private Boolean allUsersAdmin;

	@NotBlank
	private String message;

	public EmailRequest() {
		
	}
	public EmailRequest(String username,String email,String message,Boolean allUsersAdmin) {
		this.email= email;
		this.message = message;
		this.username = username;
		this.allUsersAdmin =allUsersAdmin;
	}
	public EmailRequest(String username,String email,String message) {
		this.email= email;
		this.message = message;
		this.username = username;		
	}
}
