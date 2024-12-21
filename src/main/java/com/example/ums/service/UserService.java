package com.example.ums.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ums.entity.User;
import com.example.ums.exception.UserNotFoundByIdException;
import com.example.ums.exception.UserNotFoundByNameException;
import com.example.ums.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	public User findUser(int userId) {
		
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundByIdException("User Not Found"));
	}
	public User deleteUSer(int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			User user = optional.get();
			userRepository.delete(user);
			return user;
		}else {
			throw new UserNotFoundByIdException("User Not Found");
		}
	}
	public User updateUser(User user) {
//		return userRepository.findById(user.getUserId()).map(userRepository::save).orElseThrow();	
	Optional<User> optional=	userRepository.findById(user.getUserId());
	if(optional.isPresent()) {
		
		return userRepository.save(user);
	}else {
		throw new UserNotFoundByIdException("User Not Found");
	}
	}
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username)
				.orElseThrow(()-> new UserNotFoundByNameException("Username Not Found"));
	}
		
	}

