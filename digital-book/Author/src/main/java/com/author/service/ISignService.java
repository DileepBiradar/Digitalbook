package com.author.service;

import com.author.entity.AuthorUser;
import com.author.payload.SignInRequest;
import com.author.payload.SignInResponse;

public interface ISignService {

	public SignInResponse checkUser(SignInRequest user);
	
	public SignInResponse createUser(AuthorUser user);
	
	public Boolean ifExistsUser(AuthorUser user);
}
