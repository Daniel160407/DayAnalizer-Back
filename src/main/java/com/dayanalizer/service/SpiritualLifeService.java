package com.dayanalizer.service;

import com.dayanalizer.dto.DayDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpiritualLifeService {
    List<DayDto> addRating(DayDto dayDto);

    List<DayDto> getDays(String email);
}
