package com.example.routine.controller;

import com.example.routine.dto.CommentDto;
import com.example.routine.service.impl.CommentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentServiceImpl commentService;

    @PostMapping("/{id}")
    public ResponseEntity<?> createComment(
            @PathVariable Long id,
            @Valid @RequestBody CommentDto.Request request
    ){
        return ResponseEntity.ok(commentService.createComment(id, request));
    }
}
