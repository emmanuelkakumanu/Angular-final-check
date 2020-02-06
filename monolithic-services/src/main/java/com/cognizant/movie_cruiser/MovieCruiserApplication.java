package com.cognizant.movie_cruiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieCruiserApplication {
	public static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieCruiserApplication.class);
		LOGGER.info("START");
		LOGGER.debug("Started");
	}
}
