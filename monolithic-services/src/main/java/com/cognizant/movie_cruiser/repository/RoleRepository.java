package com.cognizant.movie_cruiser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.movie_cruiser.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
