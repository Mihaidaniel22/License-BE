package com.endava.expensesmanager.controller;

import com.endava.expensesmanager.model.dto.UserDto;
import com.endava.expensesmanager.model.dto.UserRegistrationDto;
import com.endava.expensesmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {

        String name = userRegistrationDto.getName();
        String password = userRegistrationDto.getPassword();

        UserDto userDto = userService.getOrCreateUserByName(name);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
