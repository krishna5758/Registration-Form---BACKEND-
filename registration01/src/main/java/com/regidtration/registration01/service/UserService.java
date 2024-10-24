package com.regidtration.registration01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regidtration.registration01.entity.User;
import com.regidtration.registration01.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id) {
		
		return userRepository.findById(id);
				
	}
	
	public User updateUser(Long id, User userDetails) {
		
		User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
	}
	
	
}
