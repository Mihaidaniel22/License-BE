package com.endava.expensesmanager.service.impl;

import com.endava.expensesmanager.generator.JwtGenerator;
import com.endava.expensesmanager.model.dto.UserRegistrationDto;
import com.endava.expensesmanager.model.entity.UserRegistration;
import com.endava.expensesmanager.model.mapper.UserRegistrationMapper;
import com.endava.expensesmanager.repository.UserRegistrationRepository;
import com.endava.expensesmanager.service.UserRegistrationService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationServiceImpl(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    @Override
    public UserRegistrationDto registerUser(String name, String password) {

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        UserRegistration newUser = new UserRegistration();
        newUser.setName(name);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setPassword(hashedPassword);

        userRegistrationRepository.save(newUser);

        return UserRegistrationMapper.toDto(newUser);
    }

    @Override
    public String loginUser(String name, String password) {
        UserRegistration user = userRegistrationRepository.findByName(name);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return JwtGenerator.createJWT(user.getName(), user.getUserId(), 3600);
        } else {
            return "Invalid username or password";
        }
    }
}
