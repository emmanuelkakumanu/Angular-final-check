package com.cognizant.movie_cruiser.dto;


import java.util.List;

import com.cognizant.movie_cruiser.model.Movie;

public class FavoriteDTO {
	private List<Movie> movieList;
	private int count;
	
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	public double getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
