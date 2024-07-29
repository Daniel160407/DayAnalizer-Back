package com.dayanalizer.controller;

import com.dayanalizer.dto.StudyDayDto;
import com.dayanalizer.service.StudyDayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studyday")
@CrossOrigin(origins = "*")
public class StudyDayController {
    private final StudyDayService studyDayService;

    public StudyDayController(StudyDayService studyDayService) {
        this.studyDayService = studyDayService;
    }

    @PostMapping
    public ResponseEntity<?> addRating(@RequestBody StudyDayDto studyDayDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studyDayService.addRating(studyDayDto));
    }

    @GetMapping
    public ResponseEntity<?> getDays(@RequestParam int userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studyDayService.getDays(userId));
    }
}
