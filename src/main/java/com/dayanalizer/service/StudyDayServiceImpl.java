package com.dayanalizer.service;

import com.dayanalizer.dto.StudyDayDto;
import com.dayanalizer.model.DayType;
import com.dayanalizer.model.StudyDay;
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
    public List<StudyDayDto> addRating(StudyDayDto studyDayDto) {
        StudyDay studyDay = studyDayRepository.findByUserIdAndTypeAndDate(studyDayDto.getUserId(), DayType.STUDY.toString(), studyDayDto.getDate());
        if (studyDay != null) {
            studyDay.setRating(studyDayDto.getRating());
            studyDayRepository.save(studyDay);
        } else {
            studyDayRepository.save(modelConverter.convert(studyDayDto));
        }
        return modelConverter.convertDaysToDtoList(studyDayRepository.findAllByUserIdAndType(studyDayDto.getUserId(), DayType.STUDY.toString()));
    }

    @Override
    public List<StudyDayDto> getDays(int userId) {
        return modelConverter.convertDaysToDtoList(studyDayRepository.findAllByUserIdAndType(userId, DayType.STUDY.toString()));
    }
}
