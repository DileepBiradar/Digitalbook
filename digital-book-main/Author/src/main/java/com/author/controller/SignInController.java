package com.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.entity.AuthorUser;
import com.author.payload.SignInRequest;
import com.author.payload.SignInResponse;
import com.author.service.SignInServiceImp;

@RestController
@RequestMapping("/api/v1/digitalbooks/author")
@CrossOrigin(origins = "http://localhost:4200")
public class SignInController {
	
	@Autowired
	private SignInServiceImp signInService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticationCheck(@RequestBody SignInRequest signInRequest){
		return ResponseEntity.ok(signInService.checkUser(signInRequest));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody AuthorUser user){
		return new ResponseEntity<>(signInService.createUser(user),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/checkDuplicate")
	public ResponseEntity<?> checkDuplicateUser(@RequestBody AuthorUser user){
		return ResponseEntity.ok(signInService.ifExistsUser(user));
	}
	
	
}
