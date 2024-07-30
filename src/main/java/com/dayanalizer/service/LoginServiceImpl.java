package com.dayanalizer.service;

import com.dayanalizer.dto.UserDto;
import com.dayanalizer.model.User;
import com.dayanalizer.repository.UsersRepository;
import com.dayanalizer.service.exception.UserAlreadyRegisteredException;
import com.dayanalizer.service.exception.UserNotRegisteredException;
import com.dayanalizer.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UsersRepository usersRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public LoginServiceImpl(UsersRepository usersRepository, ModelConverter modelConverter) {
        this.usersRepository = usersRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public void register(UserDto userDto) {
        if (usersRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword()) == null) {
            usersRepository.save(modelConverter.convert(userDto));
        } else {
            throw new UserAlreadyRegisteredException();
        }
    }

    @Override
    public void login(UserDto userDto) {
        User user = usersRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        if (user == null) {
            throw new UserNotRegisteredException();
        }
    }
}
