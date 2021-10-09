package com.youkas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youkas.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);
	
	

}
