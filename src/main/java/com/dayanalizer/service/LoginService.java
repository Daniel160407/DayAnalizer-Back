package com.dayanalizer.service;

import com.dayanalizer.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    void register(UserDto userDto);

    Integer login(UserDto userDto);
}
