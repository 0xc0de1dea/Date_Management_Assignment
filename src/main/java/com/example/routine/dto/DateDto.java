package com.example.routine.dto;

import com.example.routine.entity.Date;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class DateDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        @NotBlank
        private String name;

        @NotBlank
        private String content;

        @NotBlank
        private String author;

        @NotBlank
        private String password;

        public Date toEntity(){
            return Date.builder()
                    .name(this.name)
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
        private String name;
        private String content;
        private String author;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

        public static DateDto.Response fromEntity(Date date){
            return Response.builder()
                    .name(date.getName())
                    .content(date.getContent())
                    .author(date.getAuthor())
                    .createdAt(date.getCreatedAt())
                    .modifiedAt(date.getModifiedAt())
                    .build();
        }
    }
}
