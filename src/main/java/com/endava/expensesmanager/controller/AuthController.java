package com.endava.expensesmanager.controller;

import com.endava.expensesmanager.model.dto.UserRegistrationDto;
import com.endava.expensesmanager.service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
    private final UserRegistrationService userRegistrationService;

    public AuthController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationDto> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {

        String name = userRegistrationDto.getName();
        String password = userRegistrationDto.getPassword();

        UserRegistrationDto newUser = userRegistrationService.registerUser(name,password);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRegistrationDto userRegistrationDto) {

        String name = userRegistrationDto.getName();
        String password = userRegistrationDto.getPassword();

        String token = userRegistrationService.loginUser(name, password);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
