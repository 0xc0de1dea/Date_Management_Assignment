package com.example.routine.service.impl;

import com.example.routine.dto.CommentDto;
import com.example.routine.entity.Comment;
import com.example.routine.entity.Date;
import com.example.routine.exception.CustomException;
import com.example.routine.repository.CommentRepository;
import com.example.routine.repository.DateRepository;
import com.example.routine.service.CommentService;
import com.example.routine.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final DateRepository dateRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentDto.Response createComment(Long id, CommentDto.Request request) {
        Date date = dateRepository.findById(id).orElseThrow(() ->
                new CustomException(ErrorCode.NOT_FOUND_ID));

        Comment comment = request.toEntity();
        comment.setModifiedAt(LocalDateTime.now());
        comment.setDate(date);
        commentRepository.save(comment);

        return CommentDto.Response.fromEntity(comment);
    }
}
