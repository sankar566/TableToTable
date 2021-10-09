package com.youkas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youkas.dto.LoginDto;
import com.youkas.dto.UserDto;
import com.youkas.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	private String userSignup(@RequestBody UserDto userDto) {
		
		
		return userService.addUser(userDto);
	}

	@PostMapping("/login")
	private String userLogin(@RequestBody LoginDto loginDto) {
		return userService.loginUser(loginDto);
		
	}
}
