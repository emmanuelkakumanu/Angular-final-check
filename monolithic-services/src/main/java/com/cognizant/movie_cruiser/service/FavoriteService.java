package com.cognizant.movie_cruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movie_cruiser.dao.FavoriteDao;
import com.cognizant.movie_cruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.movie_cruiser.exception.FavoriteEmptyException;

import com.cognizant.movie_cruiser.model.Movie;
import com.cognizant.movie_cruiser.model.Users;
import com.cognizant.movie_cruiser.repository.MovieRepository;
import com.cognizant.movie_cruiser.repository.UserRepository;

@Service
public class FavoriteService {
	@Autowired
	FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();

	@Autowired
	MovieRepository movieRepository;
	@Autowired
	UserRepository userRepository;

	public boolean addFavorite(String userId, int favoriteId) {
		Users user = userRepository.findByUserName(userId);
		Movie movie = movieRepository.findById(favoriteId).get();
		// List<Movie> movieList = userRepository.getMovies(userName);
		if (user.getMovieList().contains(movie))
			return false;
		else {
			user.getMovieList().add(movie);
			userRepository.save(user);
			return true;
		}
	}

	public List<Movie> getAllFavorites(String userName) throws FavoriteEmptyException {

		return userRepository.getMovies(userName);
	}

	public int getCount(String userName) throws FavoriteEmptyException {
		return userRepository.getCount(userName);
	}

	public void removeFavorite(String userName, int favoriteId) throws FavoriteEmptyException {
		try {
			List<Movie> movieList = userRepository.getMovies(userName);
			Users users = userRepository.findByUserName(userName);
			for (Movie movie : movieList) {
				if (movie.getId() == favoriteId) {
					movieList.remove(movie);
					break;
				}
			}
			users.setMovieList(movieList);
			userRepository.save(users);
		} catch (Exception e) {
			throw new FavoriteEmptyException();
		}
	}

}
