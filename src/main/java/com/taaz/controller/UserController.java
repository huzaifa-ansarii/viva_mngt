package com.taaz.controller;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taaz.dto.UserDTO;
import com.taaz.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
@PermitAll
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
        	System.out.println("In register controller");
            // Check if the user exists in the database
            boolean userExists = userService.isUserExists(userDTO.getEmail(), userDTO.getPassword());
            
            if (!userExists) {
                return ResponseEntity.badRequest().body("User not found!!.");
            }
            return ResponseEntity.ok("User successfully login!!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user.");
        }
    }
}

