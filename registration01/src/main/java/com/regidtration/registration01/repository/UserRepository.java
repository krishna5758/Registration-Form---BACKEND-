package com.regidtration.registration01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regidtration.registration01.entity.User;

public interface UserRepository extends JpaRepository <User , Long> {

	Optional<User> findByEmail(String email);
	 
}
