package com.author.payload;

import com.author.entity.AuthorUser;

public class SignInResponse {
	
	private String message;
	private String role;
	private int statusCode;
	private AuthorUser user;
	
	
	public AuthorUser getUser() {
		return user;
	}
	public void setUser(AuthorUser user) {
		this.user = user;
	}
	public SignInResponse() {
		super();
	}
	
	public SignInResponse(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public SignInResponse(String message, String role, int statusCode, AuthorUser user) {
		super();
		this.message = message;
		this.role = role;
		this.statusCode = statusCode;
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
