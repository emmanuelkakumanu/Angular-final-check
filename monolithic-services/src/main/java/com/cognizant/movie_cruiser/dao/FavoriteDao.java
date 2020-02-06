package com.cognizant.movie_cruiser.dao;

import com.cognizant.movie_cruiser.dto.FavoriteDTO;

public interface FavoriteDao {
	public FavoriteDTO addFavorite(String userId, long movieId);

	public FavoriteDTO getAllFavorites(String userId);

	public void removeFavorite(String userId, long movieId);

}
