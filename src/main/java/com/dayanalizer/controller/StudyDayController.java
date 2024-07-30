package com.dayanalizer.controller;

import com.dayanalizer.dto.DayDto;
import com.dayanalizer.service.StudyDayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studyday")
@CrossOrigin(origins = "*")
public class StudyDayController {
    private final StudyDayService studyDayService;

    public StudyDayController(StudyDayService studyDayService) {
        this.studyDayService = studyDayService;
    }

    @PostMapping
    public ResponseEntity<?> addRating(@RequestBody DayDto dayDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studyDayService.addRating(dayDto));
    }

    @GetMapping
    public ResponseEntity<?> getDays(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studyDayService.getDays(email));
    }
}
