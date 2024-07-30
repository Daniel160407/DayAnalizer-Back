package com.dayanalizer.controller;

import com.dayanalizer.dto.DayDto;
import com.dayanalizer.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day")
@CrossOrigin(origins = "*")
public class DayController {
    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @PostMapping
    public ResponseEntity<?> addRating(@RequestBody DayDto dayDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dayService.addRating(dayDto));
    }

    @GetMapping
    public ResponseEntity<?> getDays(@RequestParam String email, @RequestParam String type) {
        return ResponseEntity.ok().body(dayService.getDays(email, type));
    }
}
