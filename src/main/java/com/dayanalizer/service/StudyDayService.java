package com.dayanalizer.service;

import com.dayanalizer.dto.StudyDayDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudyDayService {
    List<StudyDayDto> getDays(int userId);
}
