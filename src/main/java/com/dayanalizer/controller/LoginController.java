package com.dayanalizer.controller;

import com.dayanalizer.dto.UserDto;
import com.dayanalizer.service.LoginService;
import com.dayanalizer.service.exception.InvalidEmailOrPasswordException;
import com.dayanalizer.service.exception.UserAlreadyRegisteredException;
import com.dayanalizer.service.exception.UserNotRegisteredException;
import com.dayanalizer.util.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class LoginController {
    private final LoginService loginService;
    private final JwtUtils jwtUtils;

    @Autowired
    public LoginController(LoginService loginService, JwtUtils jwtUtils) {
        this.loginService = loginService;
        this.jwtUtils = jwtUtils;
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
    public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpServletResponse response) {
        try {
            loginService.login(userDto);
            val token = jwtUtils.generateToken(userDto.getEmail());
            response.addHeader(jwtUtils.JWT_HEADER, jwtUtils.JWT_PREFIX + token);
            return ResponseEntity.ok().build();
        } catch (UserNotRegisteredException | InvalidEmailOrPasswordException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
