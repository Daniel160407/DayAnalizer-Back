package com.dayanalizer.controller;

import com.dayanalizer.dto.UserDto;
import com.dayanalizer.service.LoginService;
import com.dayanalizer.service.exception.UserAlreadyRegisteredException;
import com.dayanalizer.service.exception.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        try {
            loginService.register(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserAlreadyRegisteredException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        try {
            Integer userId = loginService.login(userDto);
            return ResponseEntity.ok().body(userId);
        } catch (UserNotRegisteredException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
