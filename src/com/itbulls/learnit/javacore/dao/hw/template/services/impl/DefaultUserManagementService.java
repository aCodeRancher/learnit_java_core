package com.itbulls.learnit.javacore.dao.hw.template.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.template.dao.MySqlJdbcUserDao;
import com.itbulls.learnit.javacore.dao.hw.template.dto.converter.UserConverter;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.dao.hw.template.services.UserManagementService;
import com.itbulls.learnit.javacore.dao.hw.template.storage.impl.DefaultUserStoringService;
import com.itbulls.learnit.javacore.dao.hw.template.dto.UserDto;

public class DefaultUserManagementService implements UserManagementService {
	
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static DefaultUserManagementService instance;
	private static DefaultUserStoringService defaultUserStoringService;
	private static UserConverter userConverter;
	private static MySqlJdbcUserDao mySqlJdbcUserDao;


	static {
		defaultUserStoringService = DefaultUserStoringService.getInstance();
		userConverter = UserConverter.getInstance();
		mySqlJdbcUserDao = MySqlJdbcUserDao.getInstance();
	}

	private DefaultUserManagementService() {
	}
	
	@Override
	public String registerUser(User user) {


        UserDto userDto = userConverter.userToUserDto(user);
		mySqlJdbcUserDao.saveUser(userDto);

		return NO_ERROR_MESSAGE;
	}



	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	
	@Override
	public List<User> getUsers() {
		List<User> users = defaultUserStoringService.loadUsers();
		DefaultUser.setCounter(users.stream()
									.mapToInt(user -> user.getId())
									.max().getAsInt());
		return users;
	}

	@Override
	public User getUserByEmail(String userEmail) {
	     UserDto userDto = mySqlJdbcUserDao.getUserByEmail(userEmail);
	     return userConverter.userDtoToUser(userDto);
	}

}
