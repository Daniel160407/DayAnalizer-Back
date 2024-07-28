package com.dayanalizer.service;

import com.dayanalizer.dto.StudyDayDto;
import com.dayanalizer.repository.StudyDayRepository;
import com.dayanalizer.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyDayServiceImpl implements StudyDayService {
    private final StudyDayRepository studyDayRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public StudyDayServiceImpl(StudyDayRepository studyDayRepository, ModelConverter modelConverter) {
        this.studyDayRepository = studyDayRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public List<StudyDayDto> getDays(int userId) {
        return modelConverter.convertDaysToDtoList(studyDayRepository.findAllByUserId(userId));
    }
}
