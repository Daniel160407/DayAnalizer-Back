package com.dayanalizer.util;

import com.dayanalizer.dto.DayDto;
import com.dayanalizer.dto.TableDto;
import com.dayanalizer.dto.UserDto;
import com.dayanalizer.model.Day;
import com.dayanalizer.model.Table;
import com.dayanalizer.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelConverter {
    public List<DayDto> convertDaysToDtoList(List<Day> days) {
        List<DayDto> dayDtos = new ArrayList<>();

        days.forEach(day -> dayDtos.add(new DayDto(day.getDate(), day.getRating(), day.getType())));
        return dayDtos;
    }

    public List<TableDto> convertTablesToDtoList(List<Table> tables) {
        List<TableDto> tableDtos = new ArrayList<>();

        tables.forEach(table -> tableDtos.add(new TableDto(table.getName(), table.getQuestion())));
        return tableDtos;
    }

    public User convert(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

    public Day convert(DayDto dayDto) {
        return Day.builder()
                .date(dayDto.getDate())
                .rating(dayDto.getRating())
                .type(dayDto.getType())
                .build();
    }

    public Table convert(TableDto tableDto) {
        return Table.builder()
                .name(tableDto.getName())
                .question(tableDto.getQuestion())
                .build();
    }
}
