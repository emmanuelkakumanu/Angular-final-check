package com.cognizant.movie_cruiser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movie_cruiser.dto.FavoriteDTO;
import com.cognizant.movie_cruiser.exception.FavoriteEmptyException;
import com.cognizant.movie_cruiser.service.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	@Autowired
	FavoriteService favoriteService;

	@PostMapping("/{userId}/{favoriteId}")
	public boolean addCartItem(@RequestBody @PathVariable("userId") String userId,
			@PathVariable("favoriteId") int favoriteId) {

		// System.out.println(userId+" "+favoriteId);
		return favoriteService.addFavorite(userId, favoriteId);

	}

	@GetMapping("/{userId}")
	public FavoriteDTO get(@PathVariable("userId") String userId) throws FavoriteEmptyException {
		FavoriteDTO favoriteDTO = new FavoriteDTO();
		try {
			favoriteDTO.setMovieList(favoriteService.getAllFavorites(userId));
			favoriteDTO.setCount(favoriteService.getCount(userId));
			// System.out.println(cartDTO.getMenuItemList());
			return favoriteDTO;
		} catch (FavoriteEmptyException e) {
			throw new FavoriteEmptyException();
		}
	}

	@DeleteMapping("/{userId}/{favoriteId}")
	public void removeFavorite(@PathVariable("userId") String userId, @PathVariable("favoriteId") int favoriteId)
			throws FavoriteEmptyException {
		try {
			favoriteService.removeFavorite(userId, favoriteId);
		} catch (FavoriteEmptyException e) {
			throw new FavoriteEmptyException();
		}
	}

}
