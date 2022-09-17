package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.author.entity.AuthorUser;
import com.author.payload.SignInRequest;
import com.author.payload.SignInResponse;

@Service
public class SignInServiceImp implements ISignService {

	@Autowired
	private ISignInRepository signInRepo;

	@Override
	public SignInResponse checkUser(SignInRequest user) {
		try {
			AuthorUser obj = signInRepo.findByEmail(user.getEmail());
			if (!(obj != null)) {
				return new SignInResponse("User not found", 415);
			} else if (!(user.getPassWord().equals(obj.getPassWord()))) {
				return new SignInResponse("Incorrect Password", 415);
			} else {
				return new SignInResponse("SUCCESS", obj.getRole(), 201, obj);
			}
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		return new SignInResponse("Something went wrong", 415);

	}

	@Override
	public SignInResponse createUser(AuthorUser user) {
		try {
			System.out.println(user);
			AuthorUser obj = signInRepo.save(user);
			AuthorUser obj1=new AuthorUser(obj.getUserId(),obj.getUserName(),obj.getEmail(),obj.getRole(),null);
			return new SignInResponse("User created successfully", obj.getRole(), 201, obj1);
		} catch (Exception ex) {
			return new SignInResponse("Something went wrong", 415);
		}

	}

	@Override
	public Boolean ifExistsUser(AuthorUser user) {
		boolean obj= signInRepo.existsByEmail(user.getEmail());
		return obj;
	}

}
