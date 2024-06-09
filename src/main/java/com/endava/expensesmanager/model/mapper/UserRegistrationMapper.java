package com.endava.expensesmanager.model.mapper;

import com.endava.expensesmanager.model.dto.UserDto;
import com.endava.expensesmanager.model.dto.UserRegistrationDto;
import com.endava.expensesmanager.model.entity.User;
import com.endava.expensesmanager.model.entity.UserRegistration;

public class UserRegistrationMapper {

    public static UserRegistrationDto toDto(UserRegistration user)
    {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setId(user.getUserId());
        userRegistrationDto.setName(user.getName());
        userRegistrationDto.setPassword(user.getPassword());
        return userRegistrationDto;
    }
}
