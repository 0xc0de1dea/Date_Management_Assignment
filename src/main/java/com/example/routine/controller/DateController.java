package com.example.routine.controller;

import com.example.routine.dto.DateDto;
import com.example.routine.service.impl.DateServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/date")
public class DateController {
    private final DateServiceImpl dateService;

    @PostMapping
    public ResponseEntity<?> createDate(
            @Valid @RequestBody DateDto.Request request
    ){
        return ResponseEntity.ok(dateService.createDate(request));
    }

    @GetMapping
    public ResponseEntity<?> searchDateByAuthor(
            @RequestParam(name = "author") String author
    ){
        return ResponseEntity.ok(dateService.searchDateByAuthor(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchDateById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(dateService.searchDateCommentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDate(
            @PathVariable Long id,
            @Valid @RequestBody DateDto.Request request
    ){
        return ResponseEntity.ok(dateService.updateDate(id, request));
    }

    @DeleteMapping
    public void deleteDate(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "password") String password
    ){
        dateService.deleteDate(id, password);
    }
}
