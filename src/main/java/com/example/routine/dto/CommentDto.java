package com.example.routine.dto;

import com.example.routine.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class CommentDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        @NotBlank
        private String content;

        @NotBlank
        private String author;

        @NotBlank
        private String password;

        public Comment toEntity(){
            return Comment.builder()
                    .content(this.content)
                    .author(this.author)
                    .password(this.password)
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private String content;
        private String author;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

        public static CommentDto.Response fromEntity(Comment comment){
            return Response.builder()
                    .content(comment.getContent())
                    .author(comment.getAuthor())
                    .createdAt(comment.getCreatedAt())
                    .modifiedAt(comment.getModifiedAt())
                    .build();
        }
    }
}
