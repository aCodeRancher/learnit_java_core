package com.itbulls.learnit.javacore.dao.hw.template.dto.converter;

import com.itbulls.learnit.javacore.dao.hw.template.dto.UserDto;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.impl.DefaultUser;


public class UserConverter {

    private static UserConverter instance;

    private UserConverter() {};


    public static UserConverter getInstance() {
        if (instance == null) {
            instance = new UserConverter();
        }
        return instance;
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User userDtoToUser(UserDto userDto){
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        int id = userDto.getId();
        String password = userDto.getPassword();
        String email = userDto.getEmail();
        User user = new DefaultUser(id ,firstName,lastName, password, email);
        return user;
      }


}
