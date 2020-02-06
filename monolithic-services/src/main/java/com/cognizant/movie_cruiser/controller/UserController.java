package com.cognizant.movie_cruiser.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movie_cruiser.exception.UserAlreadyExistsException;
import com.cognizant.movie_cruiser.model.Users;
import com.cognizant.movie_cruiser.service.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@PostMapping
	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		appUserDetailsService.signUp(user);
	}

	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
