package com.cognizant.movie_cruiser.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.movie_cruiser.exception.UserAlreadyExistsException;
import com.cognizant.movie_cruiser.model.Role;
import com.cognizant.movie_cruiser.model.Users;
import com.cognizant.movie_cruiser.repository.RoleRepository;
import com.cognizant.movie_cruiser.repository.UserRepository;
import com.cognizant.movie_cruiser.security.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new AppUser(user);
	}

	public void signUp(Users user) throws UserAlreadyExistsException {
		if (userRepository.findByUserName(user.getUserName()) != null) {
			throw new UserAlreadyExistsException();
		} else {
			Set<Role> roles = new HashSet<>();
			Role role = roleRepository.findById(1).get();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);

		}
	}

}
