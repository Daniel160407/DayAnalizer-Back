package com.dayanalizer.service;

import com.dayanalizer.dto.UserDto;
import com.dayanalizer.model.User;
import com.dayanalizer.repository.UsersRepository;
import com.dayanalizer.service.exception.InvalidEmailOrPasswordException;
import com.dayanalizer.service.exception.UserAlreadyRegisteredException;
import com.dayanalizer.service.exception.UserNotRegisteredException;
import com.dayanalizer.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UsersRepository usersRepository;
    private final ModelConverter modelConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(UsersRepository usersRepository, ModelConverter modelConverter, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.modelConverter = modelConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserDto userDto) {
        User user = usersRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            usersRepository.save(modelConverter.convert(userDto));
        } else {
            throw new UserAlreadyRegisteredException();
        }
    }

    @Override
    public void login(UserDto userDto) {
        User user = usersRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            throw new UserNotRegisteredException();
        } else if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new InvalidEmailOrPasswordException();
        }
    }
}
