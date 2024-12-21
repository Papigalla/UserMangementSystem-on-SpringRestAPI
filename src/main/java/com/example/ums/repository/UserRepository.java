package com.example.ums.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ums.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	@Query("FROM User WHERE username=:username")
	Optional<User> findUserByUsername(String username);

}
