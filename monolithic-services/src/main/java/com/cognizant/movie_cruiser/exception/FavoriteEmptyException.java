package com.cognizant.movie_cruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "favorite not found")
public class FavoriteEmptyException extends Exception {

	public FavoriteEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
