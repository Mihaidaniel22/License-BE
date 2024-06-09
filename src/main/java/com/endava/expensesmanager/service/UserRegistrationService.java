package com.endava.expensesmanager.service;

import com.endava.expensesmanager.model.dto.UserRegistrationDto;

public interface UserRegistrationService {
    UserRegistrationDto registerUser(String name, String password);
    String loginUser(String name, String password);
}
