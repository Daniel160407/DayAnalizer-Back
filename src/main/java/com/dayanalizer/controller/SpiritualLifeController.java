package com.dayanalizer.controller;

import com.dayanalizer.dto.DayDto;
import com.dayanalizer.service.SpiritualLifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spiritualLife")
@CrossOrigin(origins = "*")
public class SpiritualLifeController {
    private final SpiritualLifeService spiritualLifeService;

    @Autowired
    public SpiritualLifeController(SpiritualLifeService spiritualLifeService) {
        this.spiritualLifeService = spiritualLifeService;
    }

    @PostMapping
    public ResponseEntity<?> addRating(@RequestBody DayDto dayDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(spiritualLifeService.addRating(dayDto));
    }

    @GetMapping
    public ResponseEntity<?> getDays(@RequestParam String email) {
        return ResponseEntity.ok().body(spiritualLifeService.getDays(email));
    }
}
