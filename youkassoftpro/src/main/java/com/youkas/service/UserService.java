package com.youkas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youkas.dto.LoginDto;
import com.youkas.dto.UserDto;
import com.youkas.model.User;
import com.youkas.repo.UserRepo;
import com.youkas.util.PasswordUtils;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public String addUser(UserDto userDto) {
		
		if(userDto != null) {
			User userData = userRepo.findByUserName(userDto.getUserName());
			if(userData != null) {
				return "UserName Already Exist Please Enter another username..........";
			}else {
			User user = new User();
			user.setUserName(userDto.getUserName());
			user.setPassword(PasswordUtils.generateSecurePassword(userDto.getPassword()));
			user.setUserType(userDto.getUserType());
			userRepo.save(user);
			return "User successfully Registred..........";
			}
		}else {
			return "Bad Request unable to proces ..........";
		}
		
	}

	public String loginUser(LoginDto loginDto) {
		
		User userData = userRepo.findByUserName(loginDto.getUserName());
		if(userData != null) {
			Boolean status = PasswordUtils.verifyUserPassword(loginDto.getPassword(),userData.getPassword());
			
			if(status) {
				
				
				return "User successfully LogedIn";
			}else {
				return "InValid password...";	
			}
		}else {
			
			return "InValid user...";
		}
		
		
		
	}

}
