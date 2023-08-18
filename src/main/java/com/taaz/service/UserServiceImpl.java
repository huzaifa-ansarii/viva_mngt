package com.taaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taaz.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	   @Autowired
	    private UserRepository userRepository;

	    @Override
	    public boolean isUserExists(String email, String password) {
	        return userRepository.existsByEmailAndPassword(email, password);
	    }

}
