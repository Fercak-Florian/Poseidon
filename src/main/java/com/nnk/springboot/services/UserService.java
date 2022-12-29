package com.nnk.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(int id, User user) {
		User userToUpdate = userRepository.findById(id).get();
		userToUpdate.setUsername(user.getUsername());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setFullname(user.getFullname());
		userToUpdate.setRole(user.getRole());
		User updatedUser = userRepository.save(userToUpdate);
		return updatedUser;
	}
	
	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id : " + id));
        userRepository.delete(user);
	}
}
