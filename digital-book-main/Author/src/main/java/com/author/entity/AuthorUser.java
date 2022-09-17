package com.author.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AuthorUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String email;
	private String role;
	private String passWord;
	
	
	public AuthorUser() {
		super();
	}
	public AuthorUser(int userId, String userName, String email, String role, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.role = role;
		this.passWord = passWord;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AuthorUser [userId=" + userId + ", userName=" + userName + ", email=" + email + ", role=" + role
				+ ", passWord=" + passWord + "]";
	}
	
}
