package com.dayanalizer.controller;

import com.dayanalizer.dto.StudyDayDto;
import com.dayanalizer.service.StudyDayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studyday")
@CrossOrigin(origins = "*")
public class StudyDayController {
    private final StudyDayService studyDayService;

    public StudyDayController(StudyDayService studyDayService) {
        this.studyDayService = studyDayService;
    }

    @PostMapping
    public List<StudyDayDto> addRating(@RequestBody StudyDayDto studyDayDto) {
        return studyDayService.addRating(studyDayDto);
    }

    @GetMapping
    public List<StudyDayDto> getDays(@RequestParam int userId) {
        return studyDayService.getDays(userId);
    }
}
