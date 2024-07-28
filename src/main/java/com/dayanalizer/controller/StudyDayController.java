package com.dayanalizer.controller;

import com.dayanalizer.dto.StudyDayDto;
import com.dayanalizer.service.StudyDayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/studyday")
@CrossOrigin(origins = "*")
public class StudyDayController {
    private final StudyDayService studyDayService;

    public StudyDayController(StudyDayService studyDayService) {
        this.studyDayService = studyDayService;
    }

    @GetMapping
    public List<StudyDayDto> getDays(@RequestParam int userId) {
        return studyDayService.getDays(userId);
    }
}
