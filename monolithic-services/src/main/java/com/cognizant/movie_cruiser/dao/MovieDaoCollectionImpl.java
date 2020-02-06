package com.cognizant.movie_cruiser.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.movie_cruiser.model.Movie;

@Component
public class MovieDaoCollectionImpl implements MovieDao {
	private static ArrayList<Movie> movieList;

	public MovieDaoCollectionImpl() {
		super();
		ApplicationContext container = new ClassPathXmlApplicationContext("movie_cruiser.xml");
		movieList = container.getBean("movieList", ArrayList.class);
	}

	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public void modifyMovie(Movie movie) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movie.getId())
				movieList.set(i, movie);
		}

	}

	@Override
	public Movie getMovie(long movieId) {
		for (Movie movie : movieList) {
			if (movie.getId() == movieId)
				return movie;
		}
		return null;
	}

	public boolean addMovie(Movie movie) {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		if (movieDao.getMovie(movie.getId()) == null) {
			movieList.add(movie);
			return true;
		} else
			return false;

	}

}
