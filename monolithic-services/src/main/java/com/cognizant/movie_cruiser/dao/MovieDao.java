package com.cognizant.movie_cruiser.dao;

import java.util.List;


import com.cognizant.movie_cruiser.model.Movie;



public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(Movie movie);

	public Movie getMovie(long movieId);
	public boolean addMovie(Movie movie) ;

}
