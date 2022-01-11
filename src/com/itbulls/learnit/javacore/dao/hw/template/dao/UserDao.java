package com.itbulls.learnit.javacore.dao.hw.template.dao;

import com.itbulls.learnit.javacore.dao.hw.template.dto.UserDto;

public interface UserDao {
	
	UserDto getUserById(int id); 
	UserDto getUserByEmail(String email);
	void saveUser(UserDto user);

}
