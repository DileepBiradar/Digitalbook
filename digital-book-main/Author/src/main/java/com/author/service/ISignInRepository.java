package com.author.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.author.entity.AuthorUser;


public interface ISignInRepository extends JpaRepository<AuthorUser, Integer> {

	AuthorUser findByEmail(String email);

	Boolean existsByEmail(String email);

}
