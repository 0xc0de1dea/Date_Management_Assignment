package com.example.routine.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateCommentDto {
    private DateDto.Response date;
    private List<CommentDto.Response> comments;
}
