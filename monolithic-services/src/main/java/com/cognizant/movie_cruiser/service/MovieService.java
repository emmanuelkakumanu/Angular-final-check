package com.cognizant.movie_cruiser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movie_cruiser.dao.MovieDao;
import com.cognizant.movie_cruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.movie_cruiser.model.Movie;
import com.cognizant.movie_cruiser.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao = new MovieDaoCollectionImpl();

	@Autowired
	MovieRepository movieRepository;

	public List<Movie> getMovieListCustomer() {
		// return movieDao.getMovieListCustomer();
		return movieRepository.findAll();
	}

	public Movie getMovie(int id) {

		// return movieDao.getMovie(id);

		return movieRepository.findById(id).get();
	}

	public List<Movie> getMovieListAdmin() {

		// return movieDao.getMovieListAdmin();
		return movieRepository.findAll();
	}

	public void modifyMovie(Movie movie) {
		// movieDao.modifyMovie(movie);
		movieRepository.save(movie);

	}

}
