package com.wallacearthur.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallacearthur.workshopmongo.domain.User;
import com.wallacearthur.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(){
		
		return userRepository.findAll();
	}
}
