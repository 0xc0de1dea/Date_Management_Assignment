package com.example.routine.service;

import com.example.routine.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto.Response createComment(Long id, CommentDto.Request request);
}
