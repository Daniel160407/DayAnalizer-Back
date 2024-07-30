package com.dayanalizer.service;

import com.dayanalizer.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    void register(UserDto userDto);

    void login(UserDto userDto);
}
