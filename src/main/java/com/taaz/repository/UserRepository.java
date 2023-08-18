package com.taaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taaz.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 
	boolean existsByEmailAndPassword(String email, String password);
}
