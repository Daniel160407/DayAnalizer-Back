package com.dayanalizer.service;

import com.dayanalizer.dto.DayDto;
import com.dayanalizer.model.Day;
import com.dayanalizer.model.User;
import com.dayanalizer.repository.DayRepository;
import com.dayanalizer.repository.UsersRepository;
import com.dayanalizer.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;
    private final UsersRepository usersRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public DayServiceImpl(DayRepository dayRepository, UsersRepository usersRepository, ModelConverter modelConverter) {
        this.dayRepository = dayRepository;
        this.usersRepository = usersRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public List<DayDto> addRating(DayDto dayDto) {
        User user = usersRepository.findByEmail(dayDto.getUserEmail());
        Day day = dayRepository.findByUserIdAndTypeAndDate(user.getId(), dayDto.getType(), dayDto.getDate());
        if (day != null) {
            day.setRating(dayDto.getRating());
            day.setType(dayDto.getType());
            dayRepository.save(day);
        } else {
            Day dayToSave = modelConverter.convert(dayDto);
            dayToSave.setUserId(user.getId());
            dayToSave.setType(dayDto.getType());
            dayRepository.save(dayToSave);
        }
        return modelConverter.convertDaysToDtoList(dayRepository.findAllByUserIdAndType(user.getId(), dayDto.getType()));
    }

    @Override
    public List<DayDto> getDays(String email, String type) {
        User user = usersRepository.findByEmail(email);
        return modelConverter.convertDaysToDtoList(dayRepository.findAllByUserIdAndType(user.getId(), type));
    }
}
