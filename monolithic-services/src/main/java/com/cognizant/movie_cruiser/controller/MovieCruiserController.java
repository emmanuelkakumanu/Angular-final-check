package com.cognizant.movie_cruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movie_cruiser.model.Movie;
import com.cognizant.movie_cruiser.service.AppUserDetailsService;
import com.cognizant.movie_cruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieCruiserController {
	@Autowired
	MovieService movieService;
	public static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserController.class);
	@Autowired
	AppUserDetailsService appUserDetailsService;
	@GetMapping
	public List<Movie> getAllMenuItems() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		System.out.println("hello"+username);
		if(username=="anonymousUser")
			return movieService.getMovieListAdmin();
		UserDetails userDetails = appUserDetailsService.loadUserByUsername(username);
		String role = userDetails.getAuthorities().toArray()[0].toString();
		return movieService.getMovieListAdmin();
	}

	@GetMapping("/{id}")
	public Movie getMenuItem(@PathVariable("id") int id) {
		return movieService.getMovie(id);
	}

	@PutMapping()
	public void modifyMenuItem(@RequestBody Movie movie) {
		movieService.modifyMovie(movie);

	}

}
