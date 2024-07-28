package com.dayanalizer.util;

import com.dayanalizer.dto.StudyDayDto;
import com.dayanalizer.dto.UserDto;
import com.dayanalizer.model.StudyDay;
import com.dayanalizer.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelConverter {
    public List<StudyDayDto> convertDaysToDtoList(List<StudyDay> studyDays) {
        List<StudyDayDto> studyDayDtos = new ArrayList<>();

        studyDays.forEach(studyDay -> studyDayDtos.add(new StudyDayDto(studyDay.getDate(), studyDay.getRating(), studyDay.getType())));
        return studyDayDtos;
    }

    public User convert(UserDto userDto){
        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
