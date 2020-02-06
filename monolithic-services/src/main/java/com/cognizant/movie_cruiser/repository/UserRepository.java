package com.cognizant.movie_cruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.movie_cruiser.exception.FavoriteEmptyException;
import com.cognizant.movie_cruiser.model.Movie;
import com.cognizant.movie_cruiser.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	@Query("From Users u where u.userName like :userName")
	 Users findByUserName(String userName);
	

	@Query("select u.movieList from Users u where u.userName=:userName")
	List<Movie> getMovies(String userName)  throws FavoriteEmptyException;
	
	@Query("select count(*) from Users u join u.movieList  where u.userName=:userName")
	int getCount(String userName)throws FavoriteEmptyException;
	

}
