package com.cognizant.movie_cruiser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.movie_cruiser.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
