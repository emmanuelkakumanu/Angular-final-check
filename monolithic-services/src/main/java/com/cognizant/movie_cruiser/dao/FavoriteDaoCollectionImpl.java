package com.cognizant.movie_cruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.movie_cruiser.dto.FavoriteDTO;
import com.cognizant.movie_cruiser.model.Movie;

@Component
public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private HashMap<String, FavoriteDTO> userFavorites = new HashMap<String, FavoriteDTO>();
	FavoriteDTO newFavorite = null;

	public FavoriteDTO addFavorite(String userId, long movieId) {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(userId)) {
			if (checkMovie(userId, movieId)) {
				userFavorites.get(userId).getMovieList().add(movie);

			}

		} else {
			newFavorite = new FavoriteDTO();
			ArrayList<Movie> movies = new ArrayList<Movie>();
			movies.add(movie);
			newFavorite.setMovieList(movies);
			// newCart.setTotal(total);
			userFavorites.put(userId, newFavorite);
		}
		return newFavorite;

	}

	@Override
	public FavoriteDTO getAllFavorites(String userId) {
		FavoriteDTO favorite = userFavorites.get(userId);
		if (favorite == null || favorite.getMovieList().isEmpty()) {
			return null;
		}
		List<Movie> movieList = favorite.getMovieList();
		int count = 0;
		for (Movie movie : movieList) {
			count++;
		}
		favorite.setCount(count);
		return favorite;
	}

	@Override
	public void removeFavorite(String userId, long movieId) {
		for (Movie movie : userFavorites.get(userId).getMovieList()) {
			if (movie.getId() == movieId) {
				userFavorites.get(userId).getMovieList().remove(movie);
				break;
			}
		}

	}

	public boolean checkMovie(String userId, long movieId) {

		List<Movie> movieList = userFavorites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId)
				return false;

		}
		return true;
	}

}
