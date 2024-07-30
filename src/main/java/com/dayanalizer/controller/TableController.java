package com.dayanalizer.controller;

import com.dayanalizer.dto.TableDto;
import com.dayanalizer.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
@CrossOrigin(origins = "*")
public class TableController {
    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public ResponseEntity<?> getTables(@RequestParam String email) {
        return ResponseEntity.ok().body(tableService.getTables(email));
    }

    @PostMapping
    public ResponseEntity<?> addTable(@RequestBody TableDto tableDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tableService.addTable(tableDto));
    }

    @PutMapping
    public ResponseEntity<?> editTable(@RequestBody List<TableDto> tableDtos) {
        return ResponseEntity.ok().body(tableService.editTable(tableDtos.get(0), tableDtos.get(1)));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTable(@RequestParam String email, @RequestParam String name) {
        return ResponseEntity.ok().body(tableService.deleteTable(email, name));
    }
}
