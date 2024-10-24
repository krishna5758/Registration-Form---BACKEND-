package com.regidtration.registration01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regidtration.registration01.entity.User;
import com.regidtration.registration01.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register") // http://localhost:9422/api/users
	public ResponseEntity<User> createUser( @RequestBody User user) {
		
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping //http://localhost:9422/api/users
	public List<User> getAllUsers() {
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}") // http://localhost:9422/api/users/1
	public ResponseEntity<User> getUserById( @PathVariable Long id) {
		
		return userService.getUserById(id).map(ResponseEntity :: ok)
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@PutMapping //http://localhost:9422/api/users/1
	public ResponseEntity<User> updateUser( @PathVariable Long id, @RequestBody User userDetails) {
		
		return new ResponseEntity<>(userService.updateUser(id, userDetails), HttpStatus.OK);
	}
	
	
	@DeleteMapping //  http://localhost:9422/api/users/1
	public ResponseEntity<Void> deleteUser( @PathVariable Long id) {
		
		    userService.deleteUser(id);
		    
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
}
