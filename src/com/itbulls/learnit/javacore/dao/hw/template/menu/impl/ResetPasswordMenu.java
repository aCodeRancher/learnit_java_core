package com.itbulls.learnit.javacore.dao.hw.template.menu.impl;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import com.itbulls.learnit.javacore.dao.hw.template.dao.MySqlJdbcUserDao;
import com.itbulls.learnit.javacore.dao.hw.template.dto.UserDto;
import com.itbulls.learnit.javacore.dao.hw.template.dto.converter.UserConverter;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.template.menu.Menu;
import com.itbulls.learnit.javacore.dao.hw.template.services.ResetPasswordService;
import com.itbulls.learnit.javacore.dao.hw.template.services.UserManagementService;
import com.itbulls.learnit.javacore.dao.hw.template.services.impl.DefaultResetPasswordService;
import com.itbulls.learnit.javacore.dao.hw.template.services.impl.DefaultUserManagementService;

public class ResetPasswordMenu implements Menu {
	
	private ResetPasswordService resetPasswordService;
	private UserManagementService userManagementService;
    private MySqlJdbcUserDao mySqlJdbcUserDao;
    private UserConverter userConverter;
	{
		resetPasswordService = new DefaultResetPasswordService();
		userManagementService = DefaultUserManagementService.getInstance();
		mySqlJdbcUserDao = MySqlJdbcUserDao.getInstance();
		userConverter = UserConverter.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your email: ");
		String email = sc.next();
		System.out.print("Please, enter your new password: ");
		String updatedPassword = sc.next();


		CompletableFuture.runAsync(() -> {
			User user = userManagementService.getUserByEmail(email);
			user.setPassword(updatedPassword);
			UserDto userDto = userConverter.userToUserDto(user);
			mySqlJdbcUserDao.updateUser(userDto);
		});
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** RESET PASSWORD *****");


	}

}
